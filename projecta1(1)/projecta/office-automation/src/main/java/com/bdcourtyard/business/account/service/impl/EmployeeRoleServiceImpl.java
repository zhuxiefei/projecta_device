package com.bdcourtyard.business.account.service.impl;

import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.account.constant.RoleConstant;
import com.bdcourtyard.business.account.dao.*;
import com.bdcourtyard.business.account.domain.AddRoleReq;
import com.bdcourtyard.business.account.domain.FindPrivilegesResp;
import com.bdcourtyard.business.account.domain.FindRoleResp;
import com.bdcourtyard.business.account.domain.UpdateRoleReq;
import com.bdcourtyard.business.account.model.*;
import com.bdcourtyard.business.account.service.EmployeeRoleService;
import com.bdcourtyard.business.account.utils.EstateUtil;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.page.Page;
import com.bdcourtyard.common.utils.StringUtil;
import com.beite.tools.redis.RedisManager;
import com.beite.tools.utils.AESUtil;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * EmployeeRoleServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-16
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

    @Autowired
    private EmployeeRoleDao employeeRoleDao;

    @Autowired
    private EmployeeAccountDao employeeAccountDao;

    @Autowired
    private EmployeePrivilegeDao employeePrivilegeDao;

    @Autowired
    private EmployeeRolePrivilegeRelaDao employeeRolePrivilegeRelaDao;

    @Autowired
    private CompanyEmployeeDao empDao;

    @Autowired
    private EmployeeAccountRelaDao employeeAccountRelaDao;

    public Page<EmployeeRole> getEmployeeRolesForPage(String roleName, String estateId, Pageable pageable) {
        //去除空格
        if (!StringUtil.isEmpty(roleName)) {
            roleName = roleName.trim();
        }
        //校验入参
        if (!StringUtil.isBlank(roleName)) {
            if (!roleName.matches(RoleConstant.KEYWORD_FORMAT)) {
                // 格式错误
                throw new GlobalException("R0108");
            }
            if (roleName.length() > RoleConstant.KEYWORD_SIZE) {
                // 长度不能超过20
                throw new GlobalException("R0109");
            }
        }
        if (!StringUtil.isBlank(roleName) && roleName.contains("_")) {
            roleName = roleName.replace("_", "\\_");
        }

        long count = employeeRoleDao.getEmployeeRoles(roleName, estateId).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<EmployeeRole> employeeRoles = employeeRoleDao.getEmployeeRoles(roleName, estateId);

        Page<EmployeeRole> pageDto = new Page<EmployeeRole>();
        pageDto.setPage(pageable.getPageNumber());
        pageDto.setPageSize(pageable.getPageSize());

        if (employeeRoles != null) {
            pageDto.setRows(employeeRoles);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<EmployeeRole>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public FindPrivilegesResp findPrivileges(HttpServletRequest request) {
        FindPrivilegesResp resp = new FindPrivilegesResp();
        //先查询当前登陆人的角色ID
        String estateId = EstateUtil.getEstateId(request);
        String acctName;
        try {
            acctName = AESUtil.decrypt(request.getHeader("acctName"));
        } catch (Exception e) {
            throw new GlobalException("99999");
        }
        CompanyEmployee companyEmployee = employeeAccountDao.getRoleIdByAcctNameAndEstateId(acctName, estateId);
        //查询所有系统权限
        List<EmployeePrivilege> systems = employeePrivilegeDao.findSystems(companyEmployee.getRoleId());
        if (null != systems && systems.size() > 0) {
            for (EmployeePrivilege privilege :
                    systems) {
                if ("estate".equals(privilege.getPrivilegeName())){
                    resp.setEstateList(addPrivileges(privilege.getPrivilegeName(), privilege, companyEmployee.getRoleId()));
                }else if ("oa".equals(privilege.getPrivilegeName())){
                    resp.setOaList(addPrivileges(privilege.getPrivilegeName(), privilege, companyEmployee.getRoleId()));
                }else if ("network".equals(privilege.getPrivilegeName())){
                    resp.setNetworkList(addPrivileges(privilege.getPrivilegeName(), privilege, companyEmployee.getRoleId()));
                }else if ("assistant".equals(privilege.getPrivilegeName())){
                    resp.setAssistantList(addPrivileges(privilege.getPrivilegeName(), privilege, companyEmployee.getRoleId()));
                }else if ("crm".equals(privilege.getPrivilegeName())){
                    resp.setCrmList(addPrivileges(privilege.getPrivilegeName(), privilege, companyEmployee.getRoleId()));
                }
            }
        }
        return resp;
    }

    @Override
    public FindRoleResp findRole(String roleId) {
        FindRoleResp resp = new FindRoleResp();
        if (StringUtil.isBlank(roleId)) {
            throw new GlobalException("R0106");
        } else {
            EmployeeRole role = employeeRoleDao.getEmployeeRoleById(roleId);
            if (null == role) {
                throw new GlobalException("R0110");
            } else {
                //查询角色的所有权限（系统，菜单，按钮）
                List<EmployeePrivilege> parentPrivileges = employeeRolePrivilegeRelaDao.findParentPrivileges(roleId);
                resp.setRoleId(roleId);
                resp.setRoleName(role.getRoleName());
                resp.setRoleDesc(role.getRoleDesc());
                resp.setPrivileges(parentPrivileges);
                StringBuffer privilegeIds = new StringBuffer();
                if (parentPrivileges.size() > 0) {
                    for (EmployeePrivilege parentPrivilege : parentPrivileges) {
                        privilegeIds.append("," + parentPrivilege.getPrivilegeId());
                    }
                    String ids = privilegeIds.substring(1);
                    resp.setPrivilegeIds(ids);
                }
            }
        }
        return resp;
    }

    @Override
    public void deleteRole(String roleId) {
        if (StringUtil.isBlank(roleId)) {
            throw new GlobalException("R0106");
        } else {
            //判断角色是否关联用户
            List<CompanyEmployee> empList = empDao.findEmpByRoleId(roleId);
            if (null != empList && empList.size() > 0) {
                throw new GlobalException("R0107");
            } else {
                //删除角色
                employeeRoleDao.deleteEmployeeRoleById(roleId);
                employeeRolePrivilegeRelaDao.deteleByRoleId(roleId);
            }
        }
    }

    @Override
    public void updateRole(UpdateRoleReq roleReq, String estateId) {
        // 前后去空格
        if (!StringUtil.isEmpty(roleReq.getRoleName())) {
            roleReq.setRoleName(roleReq.getRoleName().trim());
        }
        if (!StringUtil.isEmpty(roleReq.getRoleDesc())) {
            roleReq.setRoleDesc(roleReq.getRoleDesc().trim());
        }
        if (StringUtil.isBlank(roleReq.getRoleId())) {
            throw new GlobalException("R0106");
        } else {
            //校验格式
            roleJudge(roleReq.getRoleName(), roleReq.getRoleDesc(), roleReq.getPrivilegeIds());
            if (roleReq.getRoleName().equals("admin")){
                throw new GlobalException("R0105");
            }
            boolean isUnderLine = false;
            //判断是否修改了权限，若未修改，则不使该角色的用户下线
            List<String> newIds = new ArrayList<>();
            List<String> oldIds = new ArrayList<>();
            String[] privilegeIds = roleReq.getPrivilegeIds().split(",");
            for (String id :
                    privilegeIds) {
                newIds.add(id);
            }
            List<EmployeePrivilege> parentPrivileges = employeeRolePrivilegeRelaDao.findParentPrivileges(roleReq.getRoleId());
            if (parentPrivileges != null && parentPrivileges.size() > 0) {
                for (EmployeePrivilege info :
                        parentPrivileges) {
                    oldIds.add(info.getPrivilegeId().toString());
                }
            }
            if (!compare(newIds, oldIds)) {
                //角色被修改
                isUnderLine = true;
            }
            //判断角色是否被删除
            EmployeeRole role = employeeRoleDao.getEmployeeRoleById(roleReq.getRoleId());
            if (null == role) {
                throw new GlobalException("R0110");
            }
            EmployeeRole roleIsExistence = employeeRoleDao.findRoleIsExistence(roleReq.getRoleName(), estateId);
            if (roleIsExistence == null || roleIsExistence.getRoleId().equals(roleReq.getRoleId())) {
                // 角色名称不存在或者角色名称没变 可以修改
                EmployeeRole empRole = new EmployeeRole();
                empRole.setRoleDesc(roleReq.getRoleDesc());
                empRole.setRoleId(roleReq.getRoleId());
                empRole.setRoleName(roleReq.getRoleName());
                employeeRoleDao.updateByPrimaryKeySelective(empRole);
                // 清除角色权限关系表相关数据
                employeeRolePrivilegeRelaDao.deteleByRoleId(roleReq.getRoleId());
                // 新增新的关系数据
                addRolePrivilege(roleReq.getRoleId(), roleReq.getPrivilegeIds());
                if (isUnderLine) {
                    // 查询所有拥有此角色的后台用户信息
                    List<EmployeeAccountRela> employeeAccountRelas = employeeAccountRelaDao.findByRoleId(roleReq.getRoleId());
                    // 根据用户ID清除Token 用户下线
                    if (null != employeeAccountRelas && employeeAccountRelas.size() != 0) {
                        for (EmployeeAccountRela rela :
                                employeeAccountRelas) {
                            try {
                                RedisManager.delete(AESUtil.encrypt(rela.getAcctName()));
                            } catch (Exception e) {
                                throw new GlobalException("99999");
                            }
                        }
                    }
                }
            }else {
                throw new GlobalException("R0103");
            }
        }
    }

    @Override
    public void addRole(AddRoleReq roleReq, String estateId) {
        // 名称前后去空格
        if (!StringUtil.isEmpty(roleReq.getRoleName())) {
            roleReq.setRoleName(roleReq.getRoleName().trim());
        }
        if (!StringUtil.isEmpty(roleReq.getRoleDesc())) {
            roleReq.setRoleDesc(roleReq.getRoleDesc().trim());
        }
        // 校验格式
        roleJudge(roleReq.getRoleName(), roleReq.getRoleDesc(), roleReq.getPrivilegeIds());
        EmployeeRole roleIsExistence = employeeRoleDao.findRoleIsExistence(roleReq.getRoleName(), estateId);
        if (roleIsExistence != null) {
            // 角色名称已经存在
            throw new GlobalException("R0103");
        }
        if (roleReq.getRoleName().equals("admin")){
            throw new GlobalException("R0105");
        }
        // 新增角色
        EmployeeRole role = new EmployeeRole();
        role.setRoleName(roleReq.getRoleName());
        role.setRoleId(IdUtil.getLongId() + "");
        role.setCreateTime(new Date(System.currentTimeMillis()));
        role.setRoleDesc(roleReq.getRoleDesc());
        role.setEstateId(estateId);
        employeeRoleDao.insertEmployeeRole(role);
        // 入关系表
        addRolePrivilege(role.getRoleId(), roleReq.getPrivilegeIds());
    }

    /**
     * 新增角色全系关系
     *
     * @param roleId
     * @param privilegeIds
     */
    private void addRolePrivilege(String roleId, String privilegeIds) {
        String[] privileges = privilegeIds.split(",");
        List<String> privilegeIdList = new ArrayList<>();
        //添加系统，菜单，按钮权限
        for (String p :
                privileges) {
            privilegeIdList.add(p);
        }
        //添加接口权限
        List<String> ids = employeePrivilegeDao.findPriIdByParentIds(privilegeIdList);
        if (null != ids && ids.size() > 0) {
            privilegeIdList.addAll(ids);
        }
        // 获取所有权限后入关系表
        List<EmployeeRolePrivilegeRela> relaList = new ArrayList<>();
        for (String id : privilegeIdList) {
            EmployeeRolePrivilegeRela rela = new EmployeeRolePrivilegeRela();
            rela.setRoleId(roleId);
            rela.setCreateTime(new Date(System.currentTimeMillis()));
            rela.setPrivilegeId(id);
            rela.setRpRela(IdUtil.getLongId() + "");
            relaList.add(rela);
        }
        employeeRolePrivilegeRelaDao.insertRolePrivileges(relaList);
    }

    /**
     * 比较两个list元素是否相同
     *
     * @param a
     * @param b
     * @param <T>
     * @return
     */
    public synchronized <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
        if (a.size() != b.size()) {
            return false;
        }
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * <p>
     * 角色格式校验
     * </p>
     *
     * @param roleName     角色名称
     * @param roleDesc     角色描述
     * @param privilegeIds 角色权限集合
     */
    private void roleJudge(String roleName, String roleDesc, String privilegeIds) {
        if (StringUtil.isEmpty(roleName)) {
            throw new GlobalException("R0100");
        }
        if (!roleName.matches(RoleConstant.KEYWORD_FORMAT) || roleName.length() > RoleConstant.KEYWORD_SIZE) {
            throw new GlobalException("R0101");
        }
        if (!StringUtil.isBlank(roleDesc) && roleDesc.length() > RoleConstant.ROLEDESC_SIZE) {
            throw new GlobalException("R0102");
        }
        if (StringUtil.isEmpty(privilegeIds)) {
            throw new GlobalException("R0104");
        }
    }

    /**
     * 查询权限
     *
     * @param type      系统标识
     * @param privilege 系统权限
     * @param roleId    当前登录人的角色ID
     * @return
     */
    private List<EmployeePrivilege> addPrivileges(String type, EmployeePrivilege privilege, String roleId) {
        List<EmployeePrivilege> list = new ArrayList<>();
        if (type.equals(privilege.getPrivilegeName())) {
            //加入系统权限
            list.add(privilege);
            //查询所有一级菜单权限
            List<EmployeePrivilege> firstMenuList =
                    employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(roleId, "1", privilege.getPrivilegeId());
            //定义一二级菜单权限列表
            List<EmployeePrivilege> privilegeInfos = new ArrayList<>();
            //若为oa系统，则剔除人员账号管理菜单权限
            if ("oa".equals(type)) {
                for (EmployeePrivilege p :
                        firstMenuList) {
                    //5代表账号管理菜单权限ID
                    if (!p.getPrivilegeId().equals("5")) {
                        privilegeInfos.add(p);
                    }
                }
            } else {
                privilegeInfos.addAll(firstMenuList);
            }
            //查询所有二级菜单权限
            List<EmployeePrivilege> secondMenuList = new ArrayList<>();
            for (EmployeePrivilege p :
                    privilegeInfos) {
                secondMenuList.addAll(
                        employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(roleId, "1", p.getPrivilegeId()));
            }
            privilegeInfos.addAll(secondMenuList);
            //加入菜单权限
            list.addAll(privilegeInfos);
            //查询所有按钮权限
            for (EmployeePrivilege p :
                    privilegeInfos) {
                //加入按钮权限
                list.addAll(employeePrivilegeDao.getPrivilegesByRoleIdAndParentId(roleId, "2", p.getPrivilegeId()));
            }
        }
        return list;
    }
}
