/*
Navicat MySQL Data Transfer

Source Server         : 192.168.199.250
Source Server Version : 50722
Source Host           : 192.168.199.250:3306
Source Database       : projecta

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-07-20 19:39:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for assistant_house
-- ----------------------------
DROP TABLE IF EXISTS `assistant_house`;
CREATE TABLE `assistant_house` (
  `propertyId` varchar(64) NOT NULL DEFAULT '' COMMENT '房产ID',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` varchar(5000) NOT NULL COMMENT '内容',
  `adminId` varchar(64) NOT NULL COMMENT '发布人',
  `createTime` datetime NOT NULL COMMENT '发布时间',
  `estateId` varchar(64) NOT NULL COMMENT '楼盘ID',
  PRIMARY KEY (`propertyId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房产信息表';

-- ----------------------------
-- Table structure for assistant_housefile
-- ----------------------------
DROP TABLE IF EXISTS `assistant_housefile`;
CREATE TABLE `assistant_housefile` (
  `propertyId` varchar(64) NOT NULL COMMENT '房产信息ID',
  `fileId` varchar(64) NOT NULL COMMENT '附件ID',
  `fileType` tinyint(1) NOT NULL COMMENT '1为图片 2为视频',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`propertyId`,`fileId`,`createTime`,`fileType`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='房产信息附件关联表';

-- ----------------------------
-- Table structure for assistant_houseguide
-- ----------------------------
DROP TABLE IF EXISTS `assistant_houseguide`;
CREATE TABLE `assistant_houseguide` (
  `guideId` varchar(64) NOT NULL COMMENT '看房指南ID',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` varchar(5000) NOT NULL COMMENT '内容',
  `adminId` varchar(64) NOT NULL COMMENT '发布人',
  `createTime` datetime DEFAULT NULL COMMENT '发布时间',
  `estateId` varchar(64) NOT NULL COMMENT '楼盘ID',
  PRIMARY KEY (`guideId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购房指南信息表';

-- ----------------------------
-- Table structure for assistant_onlinehouse
-- ----------------------------
DROP TABLE IF EXISTS `assistant_onlinehouse`;
CREATE TABLE `assistant_onlinehouse` (
  `onlineId` varchar(64) NOT NULL COMMENT '看房信息ID',
  `houseType` varchar(64) NOT NULL COMMENT '户型名称',
  `adminId` varchar(64) NOT NULL COMMENT '发布人',
  `createTime` datetime DEFAULT NULL COMMENT '发布时间',
  `estateId` varchar(64) NOT NULL COMMENT '楼盘ID',
  PRIMARY KEY (`onlineId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线看房信息表';

-- ----------------------------
-- Table structure for assistant_onlinehousefile
-- ----------------------------
DROP TABLE IF EXISTS `assistant_onlinehousefile`;
CREATE TABLE `assistant_onlinehousefile` (
  `onlineId` varchar(64) NOT NULL COMMENT '看房信息ID',
  `fileId` varchar(64) NOT NULL COMMENT '附件ID',
  `sceneName` varchar(64) DEFAULT NULL COMMENT '场景名称',
  `sceneSort` tinyint(1) DEFAULT NULL COMMENT '场景顺序',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`onlineId`,`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='在线看房信息附件关联表';

-- ----------------------------
-- Table structure for company_company
-- ----------------------------
DROP TABLE IF EXISTS `company_company`;
CREATE TABLE `company_company` (
  `companyId` varchar(64) NOT NULL COMMENT '企业ID',
  `companyName` varchar(128) NOT NULL COMMENT '企业名称',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业表';

-- ----------------------------
-- Table structure for company_department
-- ----------------------------
DROP TABLE IF EXISTS `company_department`;
CREATE TABLE `company_department` (
  `departmentId` varchar(64) NOT NULL COMMENT '部门ID',
  `companyId` varchar(64) NOT NULL COMMENT '公司id',
  `departmentName` varchar(128) NOT NULL COMMENT '部门名称',
  `departmentDesc` varchar(512) DEFAULT NULL COMMENT '部门描述',
  `parentDepartment` varchar(64) DEFAULT NULL COMMENT '上级部门，UUID',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '修改时间',
  `depId` varchar(64) NOT NULL DEFAULT '' COMMENT '规则ID',
  `depth` tinyint(1) NOT NULL DEFAULT '1' COMMENT '层级深度',
  `estateId` varchar(64) NOT NULL COMMENT '所属楼盘ID',
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业部门表';

-- ----------------------------
-- Table structure for company_employee
-- ----------------------------
DROP TABLE IF EXISTS `company_employee`;
CREATE TABLE `company_employee` (
  `employeeId` varchar(64) NOT NULL COMMENT '企业员工ID',
  `employeeNo` varchar(64) NOT NULL COMMENT '员工编号',
  `companyId` varchar(64) NOT NULL COMMENT '所属企业ID',
  `employeeName` varchar(64) NOT NULL COMMENT '员工姓名',
  `idNum` varchar(32) NOT NULL COMMENT '身份证号',
  `gender` tinyint(1) NOT NULL COMMENT '性别：\r\n1为男；\r\n2为女\r\n',
  `birthday` datetime NOT NULL COMMENT '生日',
  `photo` varchar(64) DEFAULT NULL COMMENT '照片ID',
  `nationality` varchar(32) DEFAULT NULL COMMENT '国籍',
  `ethnic` varchar(32) NOT NULL COMMENT '民族',
  `residency` varchar(50) NOT NULL COMMENT '籍贯',
  `height` double DEFAULT NULL COMMENT '身高，cm',
  `weight` double DEFAULT NULL COMMENT '体重，kg',
  `maritalStatus` tinyint(1) NOT NULL COMMENT '婚姻状况\r\n1为未婚，\r\n2为已婚，\r\n3为离异\r\n',
  `politicalStatus` tinyint(1) NOT NULL COMMENT '政治面貌:\r\n1为中共党员\r\n2为中共预备党员\r\n3为共青团员\r\n4为其他党派人士\r\n5为无党派人士\r\n6为群众\r\n',
  `highestEducation` tinyint(1) NOT NULL COMMENT '最高学历\r\n1为初中\r\n2为高中\r\n3为大专\r\n4为本科\r\n5为硕士\r\n6为博士\r\n7为其他\r\n',
  `graduatedFrom` varchar(64) DEFAULT NULL COMMENT '毕业院校',
  `major` varchar(64) DEFAULT NULL COMMENT '专业',
  `graduatedDate` datetime DEFAULT NULL COMMENT '毕业时间',
  `departmentId` varchar(64) DEFAULT NULL COMMENT '所属部门',
  `employType` tinyint(1) NOT NULL COMMENT '雇用性质：\r\n1为正式员工\r\n2为临时工\r\n',
  `workDate` datetime NOT NULL COMMENT '参加工作时间',
  `onBoardDate` datetime NOT NULL COMMENT '入职时间',
  `address` varchar(512) NOT NULL COMMENT '住址',
  `phoneNum` varchar(64) NOT NULL COMMENT '手机号',
  `email` varchar(64) DEFAULT NULL COMMENT '邮箱',
  `isRegular` tinyint(1) NOT NULL COMMENT '是否转正：\r\n1为转正\r\n0为未转正\r\n',
  `regularDate` datetime DEFAULT NULL COMMENT '转正日期',
  `emergencyContactPerson` varchar(128) NOT NULL COMMENT '紧急联系人姓名',
  `emergencyContactNumber` varchar(32) NOT NULL COMMENT '紧急联系人电话',
  `isEnableAccount` tinyint(1) NOT NULL COMMENT '是否启用账号登录：\r\n1为启用\r\n0为未启用\r\n',
  `roleId` varchar(64) DEFAULT NULL COMMENT '员工角色ID',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `head` varchar(64) DEFAULT NULL COMMENT '头像',
  `estateId` varchar(64) NOT NULL COMMENT '所属楼盘ID',
  PRIMARY KEY (`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业员工表';

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document` (
  `docId` varchar(64) NOT NULL DEFAULT '' COMMENT '资料ID',
  `docName` varchar(128) NOT NULL DEFAULT '' COMMENT '资料标题',
  `typeId` varchar(64) NOT NULL DEFAULT '' COMMENT '资料类型',
  `fileId` varchar(64) NOT NULL DEFAULT '' COMMENT '附件文件ID',
  `content` text COMMENT '文件内容',
  `employeeId` varchar(64) NOT NULL DEFAULT '' COMMENT '创建人ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`docId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资料表';

-- ----------------------------
-- Table structure for document_type
-- ----------------------------
DROP TABLE IF EXISTS `document_type`;
CREATE TABLE `document_type` (
  `typeId` varchar(64) NOT NULL DEFAULT '' COMMENT '资料类型Id',
  `typeName` varchar(128) NOT NULL DEFAULT '' COMMENT '类型名称',
  `typeDesc` varchar(512) DEFAULT NULL COMMENT '类型描述',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  `employeeId` varchar(64) NOT NULL COMMENT '企业员工ID',
  `updateTime` datetime NOT NULL COMMENT '更新时间',
  `estateId` varchar(64) NOT NULL COMMENT '楼盘id',
  PRIMARY KEY (`typeId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='资料类型表';

-- ----------------------------
-- Table structure for employee_account
-- ----------------------------
DROP TABLE IF EXISTS `employee_account`;
CREATE TABLE `employee_account` (
  `acctName` varchar(128) NOT NULL COMMENT '账号',
  `password` varchar(128) DEFAULT NULL COMMENT '密码',
  `isInit` tinyint(1) NOT NULL COMMENT '密码是否需要重新修改：1：不需要2：需要',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '管理员最后一次登录时间',
  `lastLoginIp` varchar(20) DEFAULT NULL COMMENT '管理员最后一次登录IP',
  `createTime` datetime NOT NULL COMMENT '账号创建时间',
  PRIMARY KEY (`acctName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物业人员账户表';

-- ----------------------------
-- Table structure for employee_account_rela
-- ----------------------------
DROP TABLE IF EXISTS `employee_account_rela`;
CREATE TABLE `employee_account_rela` (
  `acctName` varchar(128) NOT NULL COMMENT '账号',
  `employeeId` varchar(64) NOT NULL COMMENT '物业人员ID',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`acctName`,`employeeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物业人员账户关系表';

-- ----------------------------
-- Table structure for employee_privilege
-- ----------------------------
DROP TABLE IF EXISTS `employee_privilege`;
CREATE TABLE `employee_privilege` (
  `privilegeId` varchar(64) NOT NULL COMMENT '权限ID',
  `privilegeName` varchar(128) NOT NULL COMMENT '权限名称',
  `privilegeDesc` varchar(512) DEFAULT NULL COMMENT '权限描述',
  `parentId` varchar(64) DEFAULT NULL COMMENT '父权限ID',
  `privilegeType` tinyint(1) NOT NULL COMMENT '权限类型：1为菜单，2为按钮，3为接口，4为系统',
  `createTime` datetime NOT NULL COMMENT '权限创建时间',
  PRIMARY KEY (`privilegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物业人员权限表';

-- ----------------------------
-- Table structure for employee_role
-- ----------------------------
DROP TABLE IF EXISTS `employee_role`;
CREATE TABLE `employee_role` (
  `roleId` varchar(64) NOT NULL COMMENT '角色ID',
  `roleName` varchar(128) NOT NULL COMMENT '角色名称',
  `roleDesc` varchar(512) DEFAULT NULL COMMENT '角色描述',
  `createTime` datetime NOT NULL COMMENT '角色创建时间',
  `estateId` varchar(64) DEFAULT NULL COMMENT '楼盘id',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物业人员角色表';

-- ----------------------------
-- Table structure for employee_role_privilege_rela
-- ----------------------------
DROP TABLE IF EXISTS `employee_role_privilege_rela`;
CREATE TABLE `employee_role_privilege_rela` (
  `rpRela` varchar(64) NOT NULL COMMENT '关系ID',
  `roleId` varchar(64) NOT NULL COMMENT '角色ID',
  `privilegeId` varchar(64) NOT NULL COMMENT '权限ID',
  `createTime` datetime NOT NULL COMMENT '关系创建时间',
  PRIMARY KEY (`rpRela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='物业人员角色权限关系表';

-- ----------------------------
-- Table structure for equipment_repair_record
-- ----------------------------
DROP TABLE IF EXISTS `equipment_repair_record`;
CREATE TABLE `equipment_repair_record` (
  `recordId` varchar(64) NOT NULL COMMENT '记录ID',
  `equipmentId` varchar(64) NOT NULL COMMENT '设备ID',
  `equipmentOperator` varchar(64) DEFAULT NULL COMMENT '维修厂商',
  `operatorPhone` varchar(64) DEFAULT NULL COMMENT '维修厂商电话',
  `repairDesc` varchar(512) DEFAULT NULL COMMENT '维修内容',
  `repairExpense` varchar(32) DEFAULT NULL COMMENT '维修费用',
  `repairTime` datetime DEFAULT NULL COMMENT '维修日期',
  `qualityPeriod` varchar(32) DEFAULT NULL COMMENT '质保期（格式：数值,日期单位）',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备维保记录表';

-- ----------------------------
-- Table structure for equipment_type
-- ----------------------------
DROP TABLE IF EXISTS `equipment_type`;
CREATE TABLE `equipment_type` (
  `typeId` varchar(64) NOT NULL COMMENT '设备类型ID',
  `typeName` varchar(64) NOT NULL COMMENT '设备类型名称',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `estateId` varchar(64) NOT NULL COMMENT '楼盘ID',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备类型表';

-- ----------------------------
-- Table structure for estate_estate
-- ----------------------------
DROP TABLE IF EXISTS `estate_estate`;
CREATE TABLE `estate_estate` (
  `estateId` varchar(64) NOT NULL COMMENT '楼盘ID',
  `estateName` varchar(64) NOT NULL COMMENT '楼盘名称',
  `fileId` varchar(64) DEFAULT NULL COMMENT '楼盘图片ID',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`estateId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='楼盘表';

-- ----------------------------
-- Table structure for estate_start_page
-- ----------------------------
DROP TABLE IF EXISTS `estate_start_page`;
CREATE TABLE `estate_start_page` (
  `pageId` varchar(64) NOT NULL COMMENT '启动页ID',
  `name` varchar(64) NOT NULL COMMENT '描述',
  `sort` int(4) NOT NULL COMMENT '排序',
  `url` varchar(512) NOT NULL COMMENT '图片地址',
  `appType` tinyint(1) NOT NULL COMMENT '1:业主app 2:物业app3:营销助手app',
  `createTime` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`pageId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='app启动页的广告';

-- ----------------------------
-- Table structure for patrol_equipment
-- ----------------------------
DROP TABLE IF EXISTS `patrol_equipment`;
CREATE TABLE `patrol_equipment` (
  `equipmentId` varchar(64) NOT NULL COMMENT '设备ID',
  `equipmentNo` varchar(64) NOT NULL COMMENT '设备编号',
  `equipmentType` varchar(64) NOT NULL COMMENT '设备类型ID',
  `equipmentName` varchar(128) NOT NULL COMMENT '设备名称',
  `equipmentLocation` varchar(128) NOT NULL COMMENT '设备位置',
  `equipmentQRCode` mediumtext COMMENT '设备二维码',
  `equipmentDesc` varchar(6000) DEFAULT NULL COMMENT '巡检内容',
  `isCheck` tinyint(1) DEFAULT NULL COMMENT '是否需要巡检 1代表需要 2代表不需要',
  `checkCycle` tinyint(1) DEFAULT NULL COMMENT '巡检周期 \r\n1、每日巡检\r\n2、每周巡检\r\n3、月度巡检\r\n4、季度巡检\r\n5、年度巡检',
  `equipmentCreateTime` datetime DEFAULT NULL COMMENT '设备生产日期',
  `qualityPeriod` varchar(32) DEFAULT NULL COMMENT '质保期值',
  `deadline` datetime DEFAULT NULL COMMENT '报修截止日期',
  `equipmentProducer` varchar(64) NOT NULL COMMENT '设备生产厂商',
  `producerPhone` varchar(32) NOT NULL COMMENT '生产厂商电话',
  `equipmentOperator` varchar(64) NOT NULL COMMENT '设备维修厂商',
  `operatorPhone` varchar(32) NOT NULL COMMENT '维修厂商电话',
  `repairNumber` int(16) NOT NULL DEFAULT '0' COMMENT '维修次数',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `unit` tinyint(1) DEFAULT NULL COMMENT '质保期单位 ',
  `estateId` varchar(64) NOT NULL,
  PRIMARY KEY (`equipmentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='设备表';

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `confName` varchar(128) NOT NULL COMMENT '配置名称',
  `confValue` varchar(512) NOT NULL COMMENT '配置值',
  `confType` varchar(128) DEFAULT NULL COMMENT '配置类型',
  `confDesc` varchar(512) DEFAULT NULL COMMENT '配置描述',
  PRIMARY KEY (`confName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统配置';

-- ----------------------------
-- Table structure for system_file
-- ----------------------------
DROP TABLE IF EXISTS `system_file`;
CREATE TABLE `system_file` (
  `fileId` varchar(64) NOT NULL COMMENT 'UUID',
  `fileName` varchar(128) NOT NULL COMMENT '原始文件名称',
  `fileUrl` varchar(512) NOT NULL COMMENT '文件存储路径，备注：全路径',
  `fileType` tinyint(1) NOT NULL COMMENT '1视频2图片3户型图4场景图5:文档',
  `createTime` datetime NOT NULL COMMENT '文件创建时间',
  PRIMARY KEY (`fileId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统文件';

-- ----------------------------
-- Table structure for system_notice
-- ----------------------------
DROP TABLE IF EXISTS `system_notice`;
CREATE TABLE `system_notice` (
  `noticeId` varchar(64) NOT NULL COMMENT '通知ID',
  `noticeUserId` varchar(64) NOT NULL COMMENT '接收通知人ID',
  `noticeContent` varchar(512) NOT NULL COMMENT '通知内容',
  `noticeStatus` tinyint(1) NOT NULL COMMENT '通知状态：1为未读，2为已读，3为已删除',
  `noticeType` tinyint(1) NOT NULL COMMENT '通知类型：1为系统通知 2为认证通知',
  `createTime` datetime NOT NULL COMMENT '通知产生时间',
  PRIMARY KEY (`noticeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统通知';

-- ----------------------------
-- Table structure for user_account
-- ----------------------------
DROP TABLE IF EXISTS `user_account`;
CREATE TABLE `user_account` (
  `acctName` varchar(128) NOT NULL COMMENT '账号',
  `acctType` tinyint(1) NOT NULL COMMENT '账号类型：1为手机，2为用户名',
  `userId` varchar(64) NOT NULL COMMENT '账号所属用户ID',
  `createTime` datetime NOT NULL COMMENT '账号创建时间',
  PRIMARY KEY (`acctName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='C端用户账号表';

-- ----------------------------
-- Table structure for user_feedback
-- ----------------------------
DROP TABLE IF EXISTS `user_feedback`;
CREATE TABLE `user_feedback` (
  `feedbackId` varchar(64) NOT NULL COMMENT '反馈ID',
  `authorId` varchar(64) NOT NULL COMMENT '反馈提交人ID',
  `authorName` varchar(64) NOT NULL COMMENT '反馈提交人名字',
  `feedbackContent` text NOT NULL COMMENT '反馈内容',
  `feedbackType` tinyint(1) NOT NULL COMMENT '反馈类型：1为意见，2为问题',
  `feedbackStatus` tinyint(1) NOT NULL COMMENT '反馈状态：1为未读，2为已读',
  `clientModel` varchar(128) NOT NULL COMMENT '客户端型号',
  `clientVersion` varchar(32) NOT NULL COMMENT '客户端版本',
  `appType` tinyint(1) NOT NULL COMMENT 'app类型：1为业主APP，2为物业APP',
  `appVersion` varchar(32) NOT NULL COMMENT 'APP版本',
  `createTime` datetime NOT NULL COMMENT '反馈提交时间',
  `estateId` varchar(64) NOT NULL COMMENT '所属楼盘ID',
  PRIMARY KEY (`feedbackId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户意见反馈';

-- ----------------------------
-- Table structure for user_privilege
-- ----------------------------
DROP TABLE IF EXISTS `user_privilege`;
CREATE TABLE `user_privilege` (
  `privilegeId` varchar(64) NOT NULL COMMENT '权限ID',
  `privilegeName` varchar(128) NOT NULL COMMENT '权限名称',
  `privilegeDesc` varchar(512) DEFAULT NULL COMMENT '权限描述',
  `parentId` varchar(64) DEFAULT NULL COMMENT '父权限ID',
  `privilegeType` tinyint(1) NOT NULL COMMENT '权限类型：1为菜单，2为按钮，3为接口',
  `createTime` datetime NOT NULL COMMENT '权限创建时间',
  PRIMARY KEY (`privilegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='C端用户权限表';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `roleId` varchar(64) NOT NULL COMMENT '角色ID',
  `roleName` varchar(128) NOT NULL COMMENT '角色名称',
  `roleDesc` varchar(512) DEFAULT NULL COMMENT '角色描述',
  `createTime` datetime NOT NULL COMMENT '角色创建时间',
  PRIMARY KEY (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='C端用户角色表';

-- ----------------------------
-- Table structure for user_role_privilege_rela
-- ----------------------------
DROP TABLE IF EXISTS `user_role_privilege_rela`;
CREATE TABLE `user_role_privilege_rela` (
  `rpRela` varchar(64) NOT NULL COMMENT '关系ID',
  `roleId` varchar(64) NOT NULL COMMENT '角色ID',
  `privilegeId` varchar(64) NOT NULL COMMENT '权限ID',
  `createTime` datetime NOT NULL COMMENT '关系创建时间',
  PRIMARY KEY (`rpRela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='C端用户角色权限关系表';

-- ----------------------------
-- Table structure for user_user
-- ----------------------------
DROP TABLE IF EXISTS `user_user`;
CREATE TABLE `user_user` (
  `userId` varchar(64) NOT NULL COMMENT 'UUID',
  `userName` varchar(128) NOT NULL COMMENT '用户昵称',
  `userPassword` varchar(128) NOT NULL COMMENT '密码',
  `userGender` tinyint(1) DEFAULT NULL COMMENT '性别',
  `userBirthday` datetime DEFAULT NULL COMMENT '生日',
  `shiroKey` varchar(32) DEFAULT NULL COMMENT 'shiro鉴权标识（盐）',
  `userStatus` tinyint(1) NOT NULL COMMENT '用户状态：1为有效，2为禁言，3为禁止登陆，4为已删除',
  `userHead` varchar(64) DEFAULT NULL COMMENT '用户头像图片ID',
  `roleId` bigint(64) NOT NULL COMMENT '用户所属角色ID',
  `lastLoginTime` datetime DEFAULT NULL COMMENT '最后登录时间',
  `lastLoginIp` varchar(20) DEFAULT NULL COMMENT '最后登录IP',
  `createTime` datetime NOT NULL COMMENT '账号创建时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='C端用户表';
