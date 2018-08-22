package com.bdcourtyard.business.contact.service.impl;

import com.bdcourtyard.business.account.dao.CompanyEmployeeDao;
import com.bdcourtyard.business.account.model.CompanyEmployee;
import com.bdcourtyard.business.common.dao.SystemFileDao;
import com.bdcourtyard.business.common.model.SystemFile;
import com.bdcourtyard.business.contact.domain.ContactDepartment;
import com.bdcourtyard.business.contact.domain.EmployeeInfo;
import com.bdcourtyard.business.contact.domain.FindEmpUnderDepartResp;
import com.bdcourtyard.business.contact.domain.FindEmployeeResp;
import com.bdcourtyard.business.contact.service.ContactService;
import com.bdcourtyard.business.dept.dao.CompanyDepartmentDao;
import com.bdcourtyard.business.dept.model.CompanyDepartment;
import com.bdcourtyard.common.utils.PropertiesUtil;
import com.bdcourtyard.common.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * app通讯录实现类...
 * </p>
 * ClassName: ContactServiceImpl <br/>
 * Author: xiayanxin  <br/>
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ContactServiceImpl implements ContactService {

    private static final Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);

    @Autowired
    CompanyDepartmentDao departmentDao;

    @Autowired
    CompanyEmployeeDao employeeDao;

    @Autowired
    SystemFileDao systemFileDao;

    @Override
    public List<ContactDepartment> findDepartments(String estateId) {
        List<CompanyDepartment> deptResps = departmentDao.findParentDeptList(estateId);
        List<ContactDepartment> contactDepartments = new ArrayList<>();
        for (CompanyDepartment deptResp : deptResps) {
            ContactDepartment contactDepartment = new ContactDepartment();
            //查询部门下有多少员工
            int number = employeeDao.findEmpNumUnderDepart(deptResp.getDepId().substring(0, 4), estateId);
            contactDepartment.setDepartmentId(deptResp.getDepartmentId());
            contactDepartment.setDepartmentName(deptResp.getDepartmentName());
            contactDepartment.setNumber(number);
            contactDepartments.add(contactDepartment);
        }
        return contactDepartments;
    }

    @Override
    public FindEmpUnderDepartResp findEmpUnderDepart(String departmentId, String estateId) {
        FindEmpUnderDepartResp resp = new FindEmpUnderDepartResp();
        //查询该部门下所有员工
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        List<CompanyEmployee> employeeList = employeeDao.findByDepartmentId(departmentId);
        //查询该部门下所有子部门
        List<ContactDepartment> departmentList = new ArrayList<>();
        List<CompanyDepartment> depList = departmentDao.findByParentId(departmentId);
        for (CompanyEmployee employee : employeeList) {
            EmployeeInfo employeeInfo = new EmployeeInfo();
            employeeInfo.setEmployeeId(employee.getEmployeeId());
            employeeInfo.setEmployeeName(employee.getEmployeeName());
            employeeInfo.setPhoneNum(employee.getPhoneNum());
            CompanyDepartment department = departmentDao.getCompanyDepartmentById(employee.getDepartmentId());
            if (department != null) {
                employeeInfo.setDepartmentName(department.getDepartmentName());
            }
            if (null != employee.getHead()) {
                SystemFile file = systemFileDao.getSystemFileById(employee.getHead());
                if (file != null) {
                    employeeInfo.setHead(PropertiesUtil.getProperty("file.server") + file.getFileUrl());
                } else {
                    employeeInfo.setHead(null);
                }
            }
            employeeInfoList.add(employeeInfo);
        }
        for (CompanyDepartment dep :
                depList) {
            ContactDepartment contactDepartment = new ContactDepartment();
            if (dep.getDepth() == 1) {
                dep.setDepId(dep.getDepId().substring(0, 4));
            } else if (dep.getDepth() == 2) {
                dep.setDepId(dep.getDepId().substring(0, 8));
            } else if (dep.getDepth() == 3) {
                dep.setDepId(dep.getDepId().substring(0, 12));
            } else if (dep.getDepth() == 4) {
                dep.setDepId(dep.getDepId().substring(0, 16));
            } else if (dep.getDepth() == 5) {
                dep.setDepId(dep.getDepId().substring(0, 20));
            }
            //查询部门下有多少员工
            int number = employeeDao.findEmpNumUnderDepart(dep.getDepId(), estateId);
            contactDepartment.setDepartmentId(dep.getDepartmentId());
            contactDepartment.setDepartmentName(dep.getDepartmentName());
            contactDepartment.setNumber(number);
            departmentList.add(contactDepartment);
        }
        resp.setDepartmentList(departmentList);
        resp.setEmployeeInfoList(employeeInfoList);
        return resp;
    }

    @Override
    public FindEmployeeResp findEmployee(String employeeId) {
        FindEmployeeResp findEmployeeResp = employeeDao.findEmployee(employeeId);
        if (findEmployeeResp != null && !StringUtil.isBlank(findEmployeeResp.getHead())) {
            SystemFile file = systemFileDao.getSystemFileById(findEmployeeResp.getHead());
            if (file != null) {
                findEmployeeResp.setHead(PropertiesUtil.getProperty("file.server") + file.getFileUrl());
            }
        }
        return findEmployeeResp;
    }

    @Override
    public List<EmployeeInfo> findEmps(String departmentIds, String estateId) {
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        String[] departmentIdAttr = departmentIds.split(",");
        for (String departmentId :
                departmentIdAttr) {
            CompanyDepartment depart = departmentDao.getCompanyDepartmentById(departmentId);
            if (null != depart) {
                String depId = null;
                if (depart.getDepth() == 1) {
                    depId = depart.getDepId().substring(0, 4);
                } else if (depart.getDepth() == 2) {
                    depId = depart.getDepId().substring(0, 8);
                } else if (depart.getDepth() == 3) {
                    depId = depart.getDepId().substring(0, 12);
                } else if (depart.getDepth() == 4) {
                    depId = depart.getDepId().substring(0, 16);
                } else if (depart.getDepth() == 5) {
                    depId = depart.getDepId().substring(0, 20);
                }
                //查询该部门和该部门下所有子部门的员工
                List<CompanyEmployee> empList = employeeDao.findByDepIdAndType(depId, 1, estateId);
                if (null != empList && empList.size() > 0) {
                    for (CompanyEmployee employee :
                            empList) {
                        EmployeeInfo employeeInfo = new EmployeeInfo();
                        employeeInfo.setEmployeeId(employee.getEmployeeId());
                        employeeInfo.setEmployeeName(employee.getEmployeeName());
                        CompanyDepartment department = departmentDao.getCompanyDepartmentById(employee.getDepartmentId());
                        if (department != null) {
                            employeeInfo.setDepartmentName(department.getDepartmentName());
                        }
                        if (null != employee.getHead()) {
                            SystemFile file = systemFileDao.getSystemFileById(employee.getHead());
                            if (file != null) {
                                employeeInfo.setHead(PropertiesUtil.getProperty("file.server") + file.getFileUrl());
                            } else {
                                employeeInfo.setHead(null);
                            }
                        }
                        employeeInfoList.add(employeeInfo);
                    }
                }
            }
        }
        return employeeInfoList;
    }
}
