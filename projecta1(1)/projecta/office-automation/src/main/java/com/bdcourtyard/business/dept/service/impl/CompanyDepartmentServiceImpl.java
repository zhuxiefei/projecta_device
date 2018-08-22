package com.bdcourtyard.business.dept.service.impl;

import basic.common.core.dto.PageDto;
import basic.common.core.id.IdUtil;
import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.dept.constant.DeptConstant;
import com.bdcourtyard.business.dept.dao.CompanyCompanyDao;
import com.bdcourtyard.business.dept.dao.CompanyDepartmentDao;
import com.bdcourtyard.business.dept.model.*;
import com.bdcourtyard.business.dept.service.CompanyDepartmentService;
import com.bdcourtyard.common.exception.GlobalException;
import com.bdcourtyard.common.utils.MessageUtil;
import com.bdcourtyard.common.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * CompanyDepartmentServiceImpl
 *
 * @version : Ver 1.0
 * @date : 2018-7-13
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class CompanyDepartmentServiceImpl implements CompanyDepartmentService {

    @Autowired
    private CompanyDepartmentDao companyDepartmentDao;

    @Autowired
    private CompanyCompanyDao companyDao;

    @Autowired
    private CompanyEmployeeDao employeeDao;

    public int insertCompanyDepartment(CompanyDepartment companyDepartment) {
        return companyDepartmentDao.insertCompanyDepartment(companyDepartment);
    }

    public int insertCompanyDepartmentBatch(List<CompanyDepartment> list) {
        return companyDepartmentDao.insertCompanyDepartmentBatch(list);
    }

    public int updateCompanyDepartmentById(CompanyDepartment companyDepartment) {
        return companyDepartmentDao.updateCompanyDepartmentById(companyDepartment);
    }

    public int deleteCompanyDepartmentById(String departmentId) {
        return companyDepartmentDao.deleteCompanyDepartmentById(departmentId);
    }

    public CompanyDepartment getCompanyDepartmentById(String departmentId) {
        return companyDepartmentDao.getCompanyDepartmentById(departmentId);
    }

    public List<CompanyDepartment> getCompanyDepartments(CompanyDepartment companyDepartment) {
        return companyDepartmentDao.getCompanyDepartments(companyDepartment);

    }

    public PageDto<CompanyDepartment> getCompanyDepartmentsForPage(CompanyDepartment companyDepartment, Pageable pageable) {

        long count = companyDepartmentDao.getCompanyDepartments(companyDepartment).size();
        PageHelper.startPage(pageable.getPageNumber(), pageable.getPageSize());
        List<CompanyDepartment> companyDepartments = companyDepartmentDao.getCompanyDepartments(companyDepartment);

        PageDto<CompanyDepartment> pageDto = new PageDto<CompanyDepartment>();

        if (companyDepartments != null) {
            pageDto.setRows(companyDepartments);
            pageDto.setTotal(count);
        } else {
            pageDto.setRows(new ArrayList<CompanyDepartment>());
            pageDto.setTotal(0l);
        }

        return pageDto;
    }

    @Override
    public CompanyDepartment addDept(DeptReq deptReq, String estateId) {
        Integer depth;
        String depId = "";
        //前后去空格
        deptReq = trimDeptReq(deptReq);
        //一级部门
        if (StringUtil.isBlank(deptReq.getParentDepartment())) {
            CompanyDepartment dep = companyDepartmentDao.findNewestOneDepth(estateId);
            depth = 1;
            if (null == dep) {
                depId = "00010000000000000000";
            } else {
                Integer depId1 = Integer.parseInt(dep.getDepId().substring(0, 4)) + 1;
                if (depId1 > 9999) {
                    throw new GlobalException("D0008");
                } else {
                    if (1 == depId1.toString().length()) {
                        depId = "000" + depId1.toString() + "0000000000000000";
                    } else if (2 == depId1.toString().length()) {
                        depId = "00" + depId1.toString() + "0000000000000000";
                    } else if (3 == depId1.toString().length()) {
                        depId = "0" + depId1.toString() + "0000000000000000";
                    } else if (4 == depId1.toString().length()) {
                        depId = depId1.toString() + "0000000000000000";
                    }
                }
            }
            //判断部门名称是否重复
            CompanyDepartment department = companyDepartmentDao.findByParentIdAndName(deptReq.getDepartmentName(),
                    null, estateId);
            //验证部门
            checkAddDept(deptReq);
            if (null != department) {
                throw new GlobalException("D0003");
            }
        } else {
            //子部门
            //查询父级部门
            CompanyDepartment parentDep = companyDepartmentDao.getCompanyDepartmentById(deptReq.getParentDepartment());
            if (null == parentDep) {
                throw new GlobalException("D0006");
            }
            //自动生成orgId
            Map<String, String> map = createOrgId(parentDep);
            depth = parentDep.getDepth() + 1;
            depId = map.get("depId");
            //判断部门名称是否重复
            CompanyDepartment department = companyDepartmentDao.findByNameAndDepId(deptReq.getDepartmentName(), parentDep.getDepId().substring(0, 4));
            //验证部门
            checkAddDept(deptReq);
            if (null != department) {
                throw new GlobalException("D0003");
            }
            if (parentDep.getDepth() + 1 > 6) {
                throw new GlobalException("D0009");
            }
        }
        CompanyDepartment department = new CompanyDepartment();
        //公司名称
        CompanyCompany company = companyDao.findOne();
        if (company != null) {
            department.setCompanyId(company.getCompanyId());
        }
        department.setDepartmentId(IdUtil.getId() + "");
        department.setDepartmentName(deptReq.getDepartmentName());
        if (!StringUtil.isBlank(deptReq.getDepartmentDesc())) {
            department.setDepartmentDesc(deptReq.getDepartmentDesc());
        }
        department.setCreateTime(new Date(System.currentTimeMillis()));
        department.setUpdateTime(new Date(System.currentTimeMillis()));
        department.setDepth(depth);
        department.setDepId(depId);
        if (!StringUtil.isBlank(deptReq.getParentDepartment())) {
            department.setParentDepartment(deptReq.getParentDepartment());
        }
        department.setEstateId(estateId);
        companyDepartmentDao.insertCompanyDepartment(department);
        return department;
    }

    @Override
    public void updateDept(UpdateDeptReq deptReq, String estateId) {
        //校验
        checkUpdateDept(deptReq);
        //前后去空格
        deptReq = trimUpdateDeptReq(deptReq);
        //校验名称是否重复
        CompanyDepartment oldDep = companyDepartmentDao.getCompanyDepartmentById(deptReq.getDepartmentId());
        if (null == oldDep) {
            throw new GlobalException("D0006");
        }
        CompanyDepartment dep1 = null;
        if (StringUtil.isBlank(oldDep.getParentDepartment())) {
            //第一级部门查重
            dep1 = companyDepartmentDao.findByParentIdAndName(deptReq.getDepartmentName(),
                    null, estateId);
        }
        //部门查重
        CompanyDepartment department = companyDepartmentDao.findByNameAndDepId(deptReq.getDepartmentName(), oldDep.getDepId().substring(0, 4));
        if (null == oldDep) {
            throw new GlobalException("D0006");
        } else if (null != department && !department.getDepartmentName().equals(oldDep.getDepartmentName())) {
            throw new GlobalException("D0003");
        } else if (null != dep1 && !dep1.getDepartmentName().equals(oldDep.getDepartmentName())) {
            throw new GlobalException("D0003");
        } else {
            CompanyDepartment dep = new CompanyDepartment();
            dep.setDepartmentId(deptReq.getDepartmentId());
            dep.setDepartmentName(deptReq.getDepartmentName());
            dep.setDepartmentDesc(deptReq.getDepartmentDesc());
            dep.setUpdateTime(new Date(System.currentTimeMillis()));
            companyDepartmentDao.updateCompanyDepartmentById(dep);
        }
    }

    @Override
    public void deleteDept(DeleteDeptReq deptReq, String estateId) {
        CompanyDepartment department = companyDepartmentDao.getCompanyDepartmentById(deptReq.getDepartmentId());
        if (null != department) {
            String depId = null;
            if (department.getDepth() == 1) {
                depId = department.getDepId().substring(0, 4);
            } else if (department.getDepth() == 2) {
                depId = department.getDepId().substring(0, 8);
            } else if (department.getDepth() == 3) {
                depId = department.getDepId().substring(0, 12);
            } else if (department.getDepth() == 4) {
                depId = department.getDepId().substring(0, 16);
            } else if (department.getDepth() == 5) {
                depId = department.getDepId().substring(0, 20);
            }
            List<CompanyEmployee> emps = employeeDao.findByDepIdAndType(depId, 2, estateId);
            if (null != emps && emps.size() > 0) {
                throw new GlobalException("D0007");
            } else {
                //删除该部门以及该部门下的部门
                companyDepartmentDao.deleteByDepIdAndDepth(depId, department.getDepth());
            }
        }

    }

    @Override
    public CompanyDepartment findDeptDetail(String departmentId) {
        return companyDepartmentDao.findDeptDetail(departmentId);
    }

    @Override
    public List<FindDeptListResp> findParentDeptList(String estateId) {
        return getFindDeptListResp(companyDepartmentDao.findParentDeptList(estateId));
    }

    @Override
    public List<FindDeptListResp> findChildrenDeptList(String departmentId) {
        //判断父部门是否存在
        CompanyDepartment dept = companyDepartmentDao.getCompanyDepartmentById(departmentId);
        if (null == dept){
            throw new GlobalException("D0006");
        }else {
             return getFindDeptListResp(companyDepartmentDao.findByParentId(departmentId));
        }
    }

    /**
     * 获取部门列表回参
     * @param list
     * @return
     */
    private List<FindDeptListResp> getFindDeptListResp(List<CompanyDepartment> list){
        List<FindDeptListResp> resp = new ArrayList<>();
        if (null != list && list.size() > 0){
            for (CompanyDepartment c:
                    list) {
                //定义默认无子部门
                boolean hasChild = false;
                //查询该父部门下是否有子部门
                List<CompanyDepartment> childs = companyDepartmentDao.findByParentId(c.getDepartmentId());
                if (null != childs && childs.size() > 0){
                    hasChild = true;
                }
                FindDeptListResp r = new FindDeptListResp(c.getDepartmentId(),c.getDepartmentName(),
                        c.getDepartmentDesc(),c.getCreateTime(),hasChild);
                resp.add(r);
            }
        }
        return resp;
    }

    /**
     * 自动生成depId
     *
     * @param dep
     * @return
     * @author:cxx
     * @Date:2016年10月14日
     */
    private Map<String, String> createOrgId(CompanyDepartment dep) {
        Map<String, String> map = new HashMap<>();
        String depId = "";
        //根据上级部门查询下级部门
        List<CompanyDepartment> departments = companyDepartmentDao.findByParentId(dep.getDepartmentId());
        if (departments.size() == 0) {
            if (dep.getDepth() == 1) {
                depId = dep.getDepId().substring(0, 4) + "0001000000000000";
            } else if (dep.getDepth() == 2) {
                depId = dep.getDepId().substring(0, 8) + "000100000000";
            } else if (dep.getDepth() == 3) {
                depId = dep.getDepId().substring(0, 12) + "00010000";
            } else if (dep.getDepth() == 4) {
                depId = dep.getDepId().substring(0, 16) + "0001";
            } else {
                throw new GlobalException("D0009");
            }
        } else {
            int compareCode = 0;
            for (CompanyDepartment childDep : departments) {
                if (dep.getDepth() == 1) {
                    if (Integer.parseInt(childDep.getDepId().substring(4, 8)) > compareCode) {
                        compareCode = Integer.parseInt(childDep.getDepId().substring(4, 8));
                        if (compareCode + 1 > 9999) {
                            throw new GlobalException("D0008");
                        } else {
                            depId = dep.getDepId().substring(0, 4) + String.format("%04d", compareCode + 1) + "000000000000";
                        }
                    }
                } else if (dep.getDepth() == 2) {
                    if (Integer.parseInt(childDep.getDepId().substring(8, 12)) > compareCode) {
                        compareCode = Integer.parseInt(childDep.getDepId().substring(8, 12));
                        if (compareCode + 1 > 9999) {
                            throw new GlobalException("D0008");
                        } else {
                            depId = dep.getDepId().substring(0, 8) + String.format("%04d", compareCode + 1) + "00000000";
                        }
                    }
                } else if (dep.getDepth() == 3) {
                    if (Integer.parseInt(childDep.getDepId().substring(12, 16)) > compareCode) {
                        compareCode = Integer.parseInt(childDep.getDepId().substring(12, 16));
                        if (compareCode + 1 > 9999) {
                            throw new GlobalException("D0008");
                        } else {
                            depId = dep.getDepId().substring(0, 12) + String.format("%04d", compareCode + 1) + "0000";
                        }
                    }
                } else if (dep.getDepth() == 4) {
                    if (Integer.parseInt(childDep.getDepId().substring(16, 20)) > compareCode) {
                        compareCode = Integer.parseInt(childDep.getDepId().substring(16, 20));
                        if (compareCode + 1 > 9999) {
                            throw new GlobalException("D0008");
                        } else {
                            depId = dep.getDepId().substring(0, 16) + String.format("%04d", compareCode + 1);
                        }
                    }
                } else {
                    throw new GlobalException("D0008");
                }
            }
        }
        map.put("depId", depId);
        return map;
    }

    /**
     * 部门参数去空格
     *
     * @param deptReq
     * @return
     */
    private DeptReq trimDeptReq(DeptReq deptReq) {
        //departmentName
        if (!StringUtil.isBlank(deptReq.getDepartmentName())) {
            deptReq.setDepartmentName(deptReq.getDepartmentName().trim());
        }
        //departmentDesc
        if (!StringUtil.isBlank(deptReq.getDepartmentDesc())) {
            deptReq.setDepartmentDesc(deptReq.getDepartmentDesc().trim());
        }
        return deptReq;
    }

    /**
     * 部门参数去空格
     *
     * @param deptReq
     * @return
     */
    private UpdateDeptReq trimUpdateDeptReq(UpdateDeptReq deptReq) {
        //departmentId
        if (!StringUtil.isBlank(deptReq.getDepartmentId())) {
            deptReq.setDepartmentId(deptReq.getDepartmentId().trim());
        }
        //departmentName
        if (!StringUtil.isBlank(deptReq.getDepartmentName())) {
            deptReq.setDepartmentName(deptReq.getDepartmentName().trim());
        }
        //departmentDesc
        if (!StringUtil.isBlank(deptReq.getDepartmentDesc())) {
            deptReq.setDepartmentDesc(deptReq.getDepartmentDesc().trim());
        }
        return deptReq;
    }

    /**
     * 校验新增部门参数
     */
    private void checkAddDept(DeptReq deptReq) {
        //departmentName
        if (StringUtil.isBlank(deptReq.getDepartmentName())) {
            throw new GlobalException("D0001");
        } else {
            if (!deptReq.getDepartmentName().trim().matches(DeptConstant.NAME_RULE)) {
                throw new GlobalException("D0002");
            }
        }
        //departmentDesc
        if (!StringUtil.isBlank(deptReq.getDepartmentDesc())) {
            if (deptReq.getDepartmentDesc().trim().length() > DeptConstant.DEPT_DESC_LENGTH) {
                throw new GlobalException("D0004");
            }
        }
    }

    /**
     * 校验修改部门参数
     */
    private void checkUpdateDept(UpdateDeptReq deptReq) {
        //id
        if (StringUtil.isBlank(deptReq.getDepartmentId())) {
            throw new GlobalException("D0005");
        }
        //departmentName
        if (StringUtil.isBlank(deptReq.getDepartmentName())) {
            throw new GlobalException("D0001");
        } else {
            if (!deptReq.getDepartmentName().trim().matches(DeptConstant.NAME_RULE)) {
                throw new GlobalException("D0002");
            }
        }
        //departmentDesc
        if (!StringUtil.isBlank(deptReq.getDepartmentDesc())) {
            if (deptReq.getDepartmentDesc().trim().length() > DeptConstant.DEPT_DESC_LENGTH) {
                throw new GlobalException("D0004");
            }
        }
    }
}
