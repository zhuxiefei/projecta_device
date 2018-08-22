package com.bdcourtyard.business.account.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import java.io.Serializable;

/**
 *  CompanyEmployee
 *
 * @version : Ver 1.0
 * @date	: 2018-7-16
 */
public class CompanyEmployee  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * 企业员工ID     
     */	
	private String employeeId;

	/**
     * 员工编号
     */
	private String employeeNo;

	/**
     * 所属企业ID
     */
	private String companyId;

	/**
     * 员工姓名
     */
	private String employeeName;

	/**
     * 身份证号
     */
	private String idNum;

	/**
     * 性别：
1为男；
2为女

     */
	private Integer gender;

	/**
     * 生日
     */
	private java.util.Date birthday;

	/**
     * 照片ID
     */
	private String photo;

	/**
     * 国籍
     */
	private String nationality;

	/**
     * 民族
     */
	private String ethnic;

	/**
     * 籍贯
     */
	private String residency;

	/**
     * 身高，cm
     */
	private Double height;

	/**
     * 体重，kg
     */
	private Double weight;

	/**
     * 婚姻状况
1为未婚，
2为已婚，
3为离异
4为丧偶
     */
	private Integer maritalStatus;

	/**
     * 政治面貌:
1为中共党员
2为中共预备党员
3为共青团员
4为其他党派人士
5为无党派人士
6为群众

     */
	private Integer politicalStatus;

	/**
     * 最高学历
1为初中
2为高中
3为大专
4为本科
5为硕士
6为博士
7为其他

     */
	private Integer highestEducation;

	/**
     * 毕业院校
     */
	private String graduatedFrom;

	/**
     * 专业
     */
	private String major;

	/**
     * 毕业时间
     */
	private java.util.Date graduatedDate;

	/**
     * 所属部门
     */
	private String departmentId;

	/**
     * 雇用性质：
1为正式员工
2为临时工

     */
	private Integer employType;

	/**
     * 参加工作时间
     */
	private java.util.Date workDate;

	/**
     * 入职时间
     */
	private java.util.Date onBoardDate;

	/**
     * 住址
     */
	private String address;

	/**
     * 手机号
     */
	private String phoneNum;

	/**
     * 邮箱
     */
	private String email;

	/**
     * 是否转正：
1为转正
0为未转正

     */
	private Integer isRegular;

	/**
     * 转正日期
     */
	private java.util.Date regularDate;

	/**
     * 紧急联系人姓名
     */
	private String emergencyContactPerson;

	/**
     * 紧急联系人电话
     */
	private String emergencyContactNumber;

	/**
     * 是否启用账号登录：
1为启用
0为未启用

     */
	private Integer isEnableAccount;

	/**
     * 员工角色ID
     */
	private String roleId;

	/**
     * 创建时间
     */
	private java.util.Date createTime;

	/**
     * 更新时间
     */
	private java.util.Date updateTime;

	/**
     * 头像
     */
	private String head;

	/**
     * 所属楼盘ID
     */
	private String estateId;



	/**
	 * @param employeeId 企业员工ID
	 */
	@ApiModelProperty("企业员工ID")
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return 企业员工ID
	 */
	@ApiModelProperty("企业员工ID")
	public String getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * @param employeeNo 员工编号
	 */
	@ApiModelProperty("员工编号")
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	/**
	 * @return 员工编号
	 */
	@ApiModelProperty("员工编号")
	public String getEmployeeNo() {
		return this.employeeNo;
	}

	/**
	 * @param companyId 所属企业ID
	 */
	@ApiModelProperty("所属企业ID")
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return 所属企业ID
	 */
	@ApiModelProperty("所属企业ID")
	public String getCompanyId() {
		return this.companyId;
	}

	/**
	 * @param employeeName 员工姓名
	 */
	@ApiModelProperty("员工姓名")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return 员工姓名
	 */
	@ApiModelProperty("员工姓名")
	public String getEmployeeName() {
		return this.employeeName;
	}

	/**
	 * @param idNum 身份证号
	 */
	@ApiModelProperty("身份证号")
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	/**
	 * @return 身份证号
	 */
	@ApiModelProperty("身份证号")
	public String getIdNum() {
		return this.idNum;
	}

	/**
	 * @param gender 性别：
1为男；
2为女

	 */
	@ApiModelProperty("性别： 1为男； 2为女 ")
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/**
	 * @return 性别：
1为男；
2为女

	 */
	@ApiModelProperty("性别： 1为男； 2为女 ")
	public Integer getGender() {
		return this.gender;
	}

	/**
	 * @param birthday 生日
	 */
	@ApiModelProperty("生日")
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return 生日
	 */
	@ApiModelProperty("生日")
	public java.util.Date getBirthday() {
		return this.birthday;
	}


	/**
	 * @param photo 照片ID
	 */
	@ApiModelProperty("照片ID")
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return 照片ID
	 */
	@ApiModelProperty("照片ID")
	public String getPhoto() {
		return this.photo;
	}

	/**
	 * @param nationality 国籍
	 */
	@ApiModelProperty("国籍")
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * @return 国籍
	 */
	@ApiModelProperty("国籍")
	public String getNationality() {
		return this.nationality;
	}

	/**
	 * @param ethnic 民族
	 */
	@ApiModelProperty("民族")
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	/**
	 * @return 民族
	 */
	@ApiModelProperty("民族")
	public String getEthnic() {
		return this.ethnic;
	}

	/**
	 * @param residency 籍贯
	 */
	@ApiModelProperty("籍贯")
	public void setResidency(String residency) {
		this.residency = residency;
	}

	/**
	 * @return 籍贯
	 */
	@ApiModelProperty("籍贯")
	public String getResidency() {
		return this.residency;
	}

	/**
	 * @param height 身高，cm
	 */
	@ApiModelProperty("身高，cm")
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return 身高，cm
	 */
	@ApiModelProperty("身高，cm")
	public Double getHeight() {
		return this.height;
	}

	/**
	 * @param weight 体重，kg
	 */
	@ApiModelProperty("体重，kg")
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return 体重，kg
	 */
	@ApiModelProperty("体重，kg")
	public Double getWeight() {
		return this.weight;
	}

	/**
	 * @param maritalStatus 婚姻状况
1为未婚，
2为已婚，
3为离异
4为丧偶
	 */
	@ApiModelProperty("婚姻状况 1为未婚， 2为已婚， 3为离异 4为丧偶")
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @param maritalStatus 婚姻状况
	1为未婚，
	2为已婚，
	3为离异
	4为丧偶
	 */
	@ApiModelProperty("婚姻状况 1为未婚， 2为已婚， 3为离异 4为丧偶")
	public Integer getMaritalStatus() {
		return this.maritalStatus;
	}

	/**
	 * @param politicalStatus 政治面貌:
1为中共党员
2为中共预备党员
3为共青团员
4为其他党派人士
5为无党派人士
6为群众

	 */
	@ApiModelProperty("政治面貌: 1为中共党员 2为中共预备党员 3为共青团员 4为其他党派人士 5为无党派人士 6为群众 ")
	public void setPoliticalStatus(Integer politicalStatus) {
		this.politicalStatus = politicalStatus;
	}

	/**
	 * @return 政治面貌:
1为中共党员
2为中共预备党员
3为共青团员
4为其他党派人士
5为无党派人士
6为群众

	 */
	@ApiModelProperty("政治面貌: 1为中共党员 2为中共预备党员 3为共青团员 4为其他党派人士 5为无党派人士 6为群众 ")
	public Integer getPoliticalStatus() {
		return this.politicalStatus;
	}

	/**
	 * @param highestEducation 最高学历
1为初中
2为高中
3为大专
4为本科
5为硕士
6为博士
7为其他

	 */
	@ApiModelProperty("最高学历 1为初中 2为高中 3为大专 4为本科 5为硕士 6为博士 7为其他 ")
	public void setHighestEducation(Integer highestEducation) {
		this.highestEducation = highestEducation;
	}

	/**
	 * @return 最高学历
1为初中
2为高中
3为大专
4为本科
5为硕士
6为博士
7为其他

	 */
	@ApiModelProperty("最高学历 1为初中 2为高中 3为大专 4为本科 5为硕士 6为博士 7为其他 ")
	public Integer getHighestEducation() {
		return this.highestEducation;
	}

	/**
	 * @param graduatedFrom 毕业院校
	 */
	@ApiModelProperty("毕业院校")
	public void setGraduatedFrom(java.lang.String graduatedFrom) {
		this.graduatedFrom = graduatedFrom;
	}

	/**
	 * @return 毕业院校
	 */
	@ApiModelProperty("毕业院校")
	public java.lang.String getGraduatedFrom() {
		return this.graduatedFrom;
	}

	/**
	 * @param major 专业
	 */
	@ApiModelProperty("专业")
	public void setMajor(java.lang.String major) {
		this.major = major;
	}

	/**
	 * @return 专业
	 */
	@ApiModelProperty("专业")
	public java.lang.String getMajor() {
		return this.major;
	}

	/**
	 * @param graduatedDate 毕业时间
	 */
	@ApiModelProperty("毕业时间")
	public void setGraduatedDate(java.util.Date graduatedDate) {
		this.graduatedDate = graduatedDate;
	}

	/**
	 * @return 毕业时间
	 */
	@ApiModelProperty("毕业时间")
	public java.util.Date getGraduatedDate() {
		return this.graduatedDate;
	}


	/**
	 * @param departmentId 所属部门
	 */
	@ApiModelProperty("所属部门")
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return 所属部门
	 */
	@ApiModelProperty("所属部门")
	public String getDepartmentId() {
		return this.departmentId;
	}

	/**
	 * @param employType 雇用性质：
1为正式员工
2为临时工

	 */
	@ApiModelProperty("雇用性质： 1为正式员工 2为临时工 ")
	public void setEmployType(Integer employType) {
		this.employType = employType;
	}

	/**
	 * @return 雇用性质：
1为正式员工
2为临时工

	 */
	@ApiModelProperty("雇用性质： 1为正式员工 2为临时工 ")
	public Integer getEmployType() {
		return this.employType;
	}

	/**
	 * @param workDate 参加工作时间
	 */
	@ApiModelProperty("参加工作时间")
	public void setWorkDate(java.util.Date workDate) {
		this.workDate = workDate;
	}

	/**
	 * @return 参加工作时间
	 */
	@ApiModelProperty("参加工作时间")
	public java.util.Date getWorkDate() {
		return this.workDate;
	}


	/**
	 * @param onBoardDate 入职时间
	 */
	@ApiModelProperty("入职时间")
	public void setOnBoardDate(java.util.Date onBoardDate) {
		this.onBoardDate = onBoardDate;
	}

	/**
	 * @return 入职时间
	 */
	@ApiModelProperty("入职时间")
	public java.util.Date getOnBoardDate() {
		return this.onBoardDate;
	}


	/**
	 * @param address 住址
	 */
	@ApiModelProperty("住址")
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return 住址
	 */
	@ApiModelProperty("住址")
	public String getAddress() {
		return this.address;
	}

	/**
	 * @param phoneNum 手机号
	 */
	@ApiModelProperty("手机号")
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	/**
	 * @return 手机号
	 */
	@ApiModelProperty("手机号")
	public String getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * @param email 邮箱
	 */
	@ApiModelProperty("邮箱")
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return 邮箱
	 */
	@ApiModelProperty("邮箱")
	public String getEmail() {
		return this.email;
	}

	/**
	 * @param isRegular 是否转正：
1为转正
0为未转正

	 */
	@ApiModelProperty("是否转正： 1为转正 0为未转正 ")
	public void setIsRegular(Integer isRegular) {
		this.isRegular = isRegular;
	}

	/**
	 * @return 是否转正：
1为转正
0为未转正

	 */
	@ApiModelProperty("是否转正： 1为转正 0为未转正 ")
	public Integer getIsRegular() {
		return this.isRegular;
	}

	/**
	 * @param regularDate 转正日期
	 */
	@ApiModelProperty("转正日期")
	public void setRegularDate(java.util.Date regularDate) {
		this.regularDate = regularDate;
	}

	/**
	 * @return 转正日期
	 */
	@ApiModelProperty("转正日期")
	public java.util.Date getRegularDate() {
		return this.regularDate;
	}


	/**
	 * @param emergencyContactPerson 紧急联系人姓名
	 */
	@ApiModelProperty("紧急联系人姓名")
	public void setEmergencyContactPerson(String emergencyContactPerson) {
		this.emergencyContactPerson = emergencyContactPerson;
	}

	/**
	 * @return 紧急联系人姓名
	 */
	@ApiModelProperty("紧急联系人姓名")
	public String getEmergencyContactPerson() {
		return this.emergencyContactPerson;
	}

	/**
	 * @param emergencyContactNumber 紧急联系人电话
	 */
	@ApiModelProperty("紧急联系人电话")
	public void setEmergencyContactNumber(String emergencyContactNumber) {
		this.emergencyContactNumber = emergencyContactNumber;
	}

	/**
	 * @return 紧急联系人电话
	 */
	@ApiModelProperty("紧急联系人电话")
	public String getEmergencyContactNumber() {
		return this.emergencyContactNumber;
	}

	/**
	 * @param isEnableAccount 是否启用账号登录：
1为启用
0为未启用

	 */
	@ApiModelProperty("是否启用账号登录： 1为启用 0为未启用 ")
	public void setIsEnableAccount(Integer isEnableAccount) {
		this.isEnableAccount = isEnableAccount;
	}

	/**
	 * @return 是否启用账号登录：
1为启用
0为未启用

	 */
	@ApiModelProperty("是否启用账号登录： 1为启用 0为未启用 ")
	public Integer getIsEnableAccount() {
		return this.isEnableAccount;
	}

	/**
	 * @param roleId 员工角色ID
	 */
	@ApiModelProperty("员工角色ID")
	public void setRoleId(java.lang.String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return 员工角色ID
	 */
	@ApiModelProperty("员工角色ID")
	public String getRoleId() {
		return this.roleId;
	}

	/**
	 * @param createTime 创建时间
	 */
	@ApiModelProperty("创建时间")
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return 创建时间
	 */
	@ApiModelProperty("创建时间")
	public java.util.Date getCreateTime() {
		return this.createTime;
	}


	/**
	 * @param updateTime 更新时间
	 */
	@ApiModelProperty("更新时间")
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return 更新时间
	 */
	@ApiModelProperty("更新时间")
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}


	/**
	 * @param head 头像
	 */
	@ApiModelProperty("头像")
	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * @return 头像
	 */
	@ApiModelProperty("头像")
	public String getHead() {
		return this.head;
	}

	/**
	 * @param estateId 所属楼盘ID
	 */
	@ApiModelProperty("所属楼盘ID")
	public void setEstateId(String estateId) {
		this.estateId = estateId;
	}

	/**
	 * @return 所属楼盘ID
	 */
	@ApiModelProperty("所属楼盘ID")
	public String getEstateId() {
		return this.estateId;
	}

	@Override
	public String toString() {
		return "CompanyEmployee{" +
				"employeeId='" + employeeId + '\'' +
				", employeeNo='" + employeeNo + '\'' +
				", companyId='" + companyId + '\'' +
				", employeeName='" + employeeName + '\'' +
				", idNum='" + idNum + '\'' +
				", gender=" + gender +
				", birthday=" + birthday +
				", photo='" + photo + '\'' +
				", nationality='" + nationality + '\'' +
				", ethnic='" + ethnic + '\'' +
				", residency='" + residency + '\'' +
				", height=" + height +
				", weight=" + weight +
				", maritalStatus=" + maritalStatus +
				", politicalStatus=" + politicalStatus +
				", highestEducation=" + highestEducation +
				", graduatedFrom='" + graduatedFrom + '\'' +
				", major='" + major + '\'' +
				", graduatedDate=" + graduatedDate +
				", departmentId='" + departmentId + '\'' +
				", employType=" + employType +
				", workDate=" + workDate +
				", onBoardDate=" + onBoardDate +
				", address='" + address + '\'' +
				", phoneNum='" + phoneNum + '\'' +
				", email='" + email + '\'' +
				", isRegular=" + isRegular +
				", regularDate=" + regularDate +
				", emergencyContactPerson='" + emergencyContactPerson + '\'' +
				", emergencyContactNumber='" + emergencyContactNumber + '\'' +
				", isEnableAccount=" + isEnableAccount +
				", roleId='" + roleId + '\'' +
				", createTime=" + createTime +
				", updateTime=" + updateTime +
				", head='" + head + '\'' +
				", estateId='" + estateId + '\'' +
				'}';
	}
}
