package com.bdcourtyard.business.contact.service;

import com.bdcourtyard.business.contact.domain.ContactDepartment;
import com.bdcourtyard.business.contact.domain.EmployeeInfo;
import com.bdcourtyard.business.contact.domain.FindEmpUnderDepartResp;
import com.bdcourtyard.business.contact.domain.FindEmployeeResp;

import java.util.List;

/**
 * <p>
 * app通讯录业务类...
 * </p>
 * ClassName: ContactService <br/>
 * Author: xiayanxin <br/>
 */
public interface ContactService {

    List<ContactDepartment> findDepartments(String estateId);

    FindEmpUnderDepartResp findEmpUnderDepart(String departmentId, String estateId);

    FindEmployeeResp findEmployee(String employeeId);

    List<EmployeeInfo> findEmps(String departmentIds, String estateId);
}
