package com.bdcourtyard.business.clientmessage.model;

import io.swagger.annotations.ApiModelProperty;

public class UpdateControlClientEnteringResp {

    /**
     * 客户编号
     */
    private String clientId;

    /**
     * 客户姓名
     */
    private String clientName;

    /**
     * 年龄
     */
    private String clientAge;

    /**
     * 性别
     */
    private String clientGender;

    /**
     * 体貌特征
     */
    private String clientLooks;

    /**
     * 联系电话
     */
    private String clientPhone;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 信息来源
     */
    private String information;

    /**
     * 家庭人口
     */
    private String clientFamily;

    /**
     * 家庭结构
     */
    private String familyStructure;

    /**
     * 居住区域
     */
    private String dwellResidential;

    /**
     * 工作区域
     */
    private String workResidential;

    /**
     * 交通工具
     */
    private String vehicle;

    /**
     * 购买动机
     */
    private String motive;

    /**
     * 客户询问的重点
     */
    private String emphasis;

    /**
     * 需求产品
     */
    private String demandProduct;

    /**
     * 需求房型
     */
    private String demandHouse;

    /**
     * 需求面积
     */
    private String demandDiscount;

    /**
     * 需求总价
     */
    private String demandTotal;

    /**
     * 需求楼层
     */
    private String demandFllor;

    /**
     * 产品反映
     */
    private String productReflect;

    /**
     * 产品推荐:房号
     */
    private String productRecommendRoomNumber;

    /**
     * 产品推荐:房型
     */
    private String productRecommendHouseType;

    /**
     * 产品推荐:面积
     */
    private String productRecommendProportion;

    /**
     * 产品推荐:单价
     */
    private String productRecommendUnitPrice;

    /**
     * 产品推荐:总价
     */
    private String productRecommendTotalPrices;

    /**
     * 接待记录
     */
    private String receivingRecords;

    /**
     * 客户级别
     */
    private Integer clientRank;

    /**
     * 客户就职单位
     */
    private String clientInauguration;

    /**
     * 单位名称
     */
    private String inaugurationName;

    /**
     * 职务
     */
    private String duty;

    /**
     * 客户状态
     */
    private Integer clientState;

    /**
     * 是否需要回访 1.是 2.否
     */
    private Integer returnVisit;

    /**
     * 追踪回访记录
     */
    private String trace;

    /**
     * 是否成交
     */
    private Integer bargain;

    /**
     * 未成交因素
     */
    private String unsubmittedFactor;

    /**
     * 主管确认记录
     */
    private String confirm;

    /**
     * 备注
     */
    private String remark;
    /**
     * 客户询问重点:其他
     */
    private java.lang.String emphasisRests;

    /**
     * 客户就职单位:其他
     */
    private java.lang.String clientInaugurationRests;

    /**
     * 未成交因素:其他
     */
    private java.lang.String unsubmittedFactorRests;

    //多个回访时间
    private String[] returnTimes;

    /**
     * 客户信息来源:其他
     */
    private java.lang.String informationRests;

    /**
     * @param informationRests 客户信息来源:其他
     */
    @ApiModelProperty("客户信息来源:其他")
    public void setInformationRests(java.lang.String informationRests) {
        this.informationRests = informationRests;
    }

    /**
     * @return 客户信息来源:其他
     */
    @ApiModelProperty("客户信息来源:其他")
    public java.lang.String getInformationRests() {
        return this.informationRests;
    }

    public String[] getReturnTimes() {
        return returnTimes;
    }

    public void setReturnTimes(String[] returnTimes) {
        this.returnTimes = returnTimes;
    }

    /**
     * @param clientId 客户编号
     */
    @ApiModelProperty("客户编号")
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * @return 客户编号
     */
    @ApiModelProperty("客户编号")
    public String getClientId() {
        return this.clientId;
    }

    /**
     * @param clientName 客户姓名
     */
    @ApiModelProperty("客户姓名")
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return 客户姓名
     */
    @ApiModelProperty("客户姓名")
    public String getClientName() {
        return this.clientName;
    }

    /**
     * @param clientAge 年龄
     */
    @ApiModelProperty("年龄")
    public void setClientAge(String clientAge) {
        this.clientAge = clientAge;
    }

    /**
     * @return 年龄
     */
    @ApiModelProperty("年龄")
    public String getClientAge() {
        return this.clientAge;
    }

    /**
     * @param clientGender 性别
     */
    @ApiModelProperty("性别")
    public void setClientGender(String clientGender) {
        this.clientGender = clientGender;
    }

    /**
     * @return 性别
     */
    @ApiModelProperty("性别")
    public String getClientGender() {
        return this.clientGender;
    }

    /**
     * @param clientLooks 体貌特征
     */
    @ApiModelProperty("体貌特征")
    public void setClientLooks(String clientLooks) {
        this.clientLooks = clientLooks;
    }

    /**
     * @return 体貌特征
     */
    @ApiModelProperty("体貌特征")
    public String getClientLooks() {
        return this.clientLooks;
    }

    /**
     * @param clientPhone 联系电话
     */
    @ApiModelProperty("联系电话")
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    /**
     * @return 联系电话
     */
    @ApiModelProperty("联系电话")
    public String getClientPhone() {
        return this.clientPhone;
    }

    /**
     * @param idCard 证件号码
     */
    @ApiModelProperty("证件号码")
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * @return 证件号码
     */
    @ApiModelProperty("证件号码")
    public String getIdCard() {
        return this.idCard;
    }

    /**
     * @param information 信息来源
     */
    @ApiModelProperty("信息来源")
    public void setInformation(String information) {
        this.information = information;
    }

    /**
     * @return 信息来源
     */
    @ApiModelProperty("信息来源")
    public String getInformation() {
        return this.information;
    }

    /**
     * @param clientFamily 家庭人口
     */
    @ApiModelProperty("家庭人口")
    public void setClientFamily(String clientFamily) {
        this.clientFamily = clientFamily;
    }

    /**
     * @return 家庭人口
     */
    @ApiModelProperty("家庭人口")
    public String getClientFamily() {
        return this.clientFamily;
    }

    /**
     * @param familyStructure 家庭结构
     */
    @ApiModelProperty("家庭结构")
    public void setFamilyStructure(String familyStructure) {
        this.familyStructure = familyStructure;
    }

    /**
     * @return 家庭结构
     */
    @ApiModelProperty("家庭结构")
    public String getFamilyStructure() {
        return this.familyStructure;
    }

    /**
     * @param dwellResidential 居住区域
     */
    @ApiModelProperty("居住区域")
    public void setDwellResidential(String dwellResidential) {
        this.dwellResidential = dwellResidential;
    }

    /**
     * @return 居住区域
     */
    @ApiModelProperty("居住区域")
    public String getDwellResidential() {
        return this.dwellResidential;
    }

    /**
     * @param workResidential 工作区域
     */
    @ApiModelProperty("工作区域")
    public void setWorkResidential(String workResidential) {
        this.workResidential = workResidential;
    }

    /**
     * @return 工作区域
     */
    @ApiModelProperty("工作区域")
    public String getWorkResidential() {
        return this.workResidential;
    }

    /**
     * @param vehicle 交通工具
     */
    @ApiModelProperty("交通工具")
    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * @return 交通工具
     */
    @ApiModelProperty("交通工具")
    public String getVehicle() {
        return this.vehicle;
    }

    /**
     * @param motive 购买动机
     */
    @ApiModelProperty("购买动机")
    public void setMotive(String motive) {
        this.motive = motive;
    }

    /**
     * @return 购买动机
     */
    @ApiModelProperty("购买动机")
    public String getMotive() {
        return this.motive;
    }

    /**
     * @param emphasis 客户询问的重点
     */
    @ApiModelProperty("客户询问的重点")
    public void setEmphasis(String emphasis) {
        this.emphasis = emphasis;
    }

    /**
     * @return 客户询问的重点
     */
    @ApiModelProperty("客户询问的重点")
    public String getEmphasis() {
        return this.emphasis;
    }

    /**
     * @param demandProduct 需求产品
     */
    @ApiModelProperty("需求产品")
    public void setDemandProduct(String demandProduct) {
        this.demandProduct = demandProduct;
    }

    /**
     * @return 需求产品
     */
    @ApiModelProperty("需求产品")
    public String getDemandProduct() {
        return this.demandProduct;
    }

    /**
     * @param demandHouse 需求房型
     */
    @ApiModelProperty("需求房型")
    public void setDemandHouse(String demandHouse) {
        this.demandHouse = demandHouse;
    }

    /**
     * @return 需求房型
     */
    @ApiModelProperty("需求房型")
    public String getDemandHouse() {
        return this.demandHouse;
    }

    /**
     * @param demandDiscount 需求面积
     */
    @ApiModelProperty("需求面积")
    public void setDemandDiscount(String demandDiscount) {
        this.demandDiscount = demandDiscount;
    }

    /**
     * @return 需求面积
     */
    @ApiModelProperty("需求面积")
    public String getDemandDiscount() {
        return this.demandDiscount;
    }

    /**
     * @param demandTotal 需求总价
     */
    @ApiModelProperty("需求总价")
    public void setDemandTotal(String demandTotal) {
        this.demandTotal = demandTotal;
    }

    /**
     * @return 需求总价
     */
    @ApiModelProperty("需求总价")
    public String getDemandTotal() {
        return this.demandTotal;
    }

    /**
     * @param demandFllor 需求楼层
     */
    @ApiModelProperty("需求楼层")
    public void setDemandFllor(String demandFllor) {
        this.demandFllor = demandFllor;
    }

    /**
     * @return 需求楼层
     */
    @ApiModelProperty("需求楼层")
    public String getDemandFllor() {
        return this.demandFllor;
    }

    /**
     * @param productReflect 产品反映
     */
    @ApiModelProperty("产品反映")
    public void setProductReflect(String productReflect) {
        this.productReflect = productReflect;
    }

    /**
     * @return 产品反映
     */
    @ApiModelProperty("产品反映")
    public String getProductReflect() {
        return this.productReflect;
    }

    /**
     * @param productRecommendRoomNumber 产品推荐:房号
     */
    @ApiModelProperty("产品推荐:房号")
    public void setProductRecommendRoomNumber(String productRecommendRoomNumber) {
        this.productRecommendRoomNumber = productRecommendRoomNumber;
    }

    /**
     * @return 产品推荐:房号
     */
    @ApiModelProperty("产品推荐:房号")
    public String getProductRecommendRoomNumber() {
        return this.productRecommendRoomNumber;
    }

    /**
     * @param productRecommendHouseType 产品推荐:房型
     */
    @ApiModelProperty("产品推荐:房型")
    public void setProductRecommendHouseType(String productRecommendHouseType) {
        this.productRecommendHouseType = productRecommendHouseType;
    }

    /**
     * @return 产品推荐:房型
     */
    @ApiModelProperty("产品推荐:房型")
    public String getProductRecommendHouseType() {
        return this.productRecommendHouseType;
    }

    /**
     * @param productRecommendProportion 产品推荐:面积
     */
    @ApiModelProperty("产品推荐:面积")
    public void setProductRecommendProportion(String productRecommendProportion) {
        this.productRecommendProportion = productRecommendProportion;
    }

    /**
     * @return 产品推荐:面积
     */
    @ApiModelProperty("产品推荐:面积")
    public String getProductRecommendProportion() {
        return this.productRecommendProportion;
    }

    /**
     * @param productRecommendUnitPrice 产品推荐:单价
     */
    @ApiModelProperty("产品推荐:单价")
    public void setProductRecommendUnitPrice(String productRecommendUnitPrice) {
        this.productRecommendUnitPrice = productRecommendUnitPrice;
    }

    /**
     * @return 产品推荐:单价
     */
    @ApiModelProperty("产品推荐:单价")
    public String getProductRecommendUnitPrice() {
        return this.productRecommendUnitPrice;
    }

    /**
     * @param productRecommendTotalPrices 产品推荐:总价
     */
    @ApiModelProperty("产品推荐:总价")
    public void setProductRecommendTotalPrices(String productRecommendTotalPrices) {
        this.productRecommendTotalPrices = productRecommendTotalPrices;
    }

    /**
     * @return 产品推荐:总价
     */
    @ApiModelProperty("产品推荐:总价")
    public String getProductRecommendTotalPrices() {
        return this.productRecommendTotalPrices;
    }

    /**
     * @param receivingRecords 接待记录
     */
    @ApiModelProperty("接待记录")
    public void setReceivingRecords(String receivingRecords) {
        this.receivingRecords = receivingRecords;
    }

    /**
     * @return 接待记录
     */
    @ApiModelProperty("接待记录")
    public String getReceivingRecords() {
        return this.receivingRecords;
    }

    /**
     * @param clientRank 客户级别
     */
    @ApiModelProperty("客户级别 1.A类 2.B类 3.C类")
    public void setClientRank(Integer clientRank) {
        this.clientRank = clientRank;
    }

    /**
     * @return 客户级别
     */
    @ApiModelProperty("客户级别 1.A类 2.B类 3.C类")
    public Integer getClientRank() {
        return this.clientRank;
    }

    /**
     * @param clientInauguration 客户就职单位
     */
    @ApiModelProperty("客户就职单位")
    public void setClientInauguration(String clientInauguration) {
        this.clientInauguration = clientInauguration;
    }

    /**
     * @return 客户就职单位
     */
    @ApiModelProperty("客户就职单位")
    public String getClientInauguration() {
        return this.clientInauguration;
    }

    /**
     * @param inaugurationName 单位名称
     */
    @ApiModelProperty("单位名称")
    public void setInaugurationName(String inaugurationName) {
        this.inaugurationName = inaugurationName;
    }

    /**
     * @return 单位名称
     */
    @ApiModelProperty("单位名称")
    public String getInaugurationName() {
        return this.inaugurationName;
    }

    /**
     * @param duty 职务
     */
    @ApiModelProperty("职务")
    public void setDuty(String duty) {
        this.duty = duty;
    }

    /**
     * @return 职务
     */
    @ApiModelProperty("职务")
    public String getDuty() {
        return this.duty;
    }

    /**
     * @param clientState 客户状态
     *                    1.意向客户 2.来访客户 3.无效客户
     */
    @ApiModelProperty("客户状态 1.意向客户 2.来访客户 3.无效客户")
    public void setClientState(Integer clientState) {
        this.clientState = clientState;
    }

    /**
     * @return 客户状态
     */
    @ApiModelProperty("客户状态 1.意向客户 2.来访客户 3.无效客户")
    public Integer getClientState() {
        return this.clientState;
    }


    /**
     * @param returnVisit 是否需要回访
     *                    1.是 2.否
     */
    @ApiModelProperty("是否需要回访 1.是 2.否")
    public void setReturnVisit(Integer returnVisit) {
        this.returnVisit = returnVisit;
    }

    /**
     * @return 是否需要回访
     */
    @ApiModelProperty("是否需要回访 1.是 2.否")
    public Integer getReturnVisit() {
        return this.returnVisit;
    }


    /**
     * @param trace 追踪回访记录
     */
    @ApiModelProperty("追踪回访记录")
    public void setTrace(String trace) {
        this.trace = trace;
    }

    /**
     * @return 追踪回访记录
     */
    @ApiModelProperty("追踪回访记录")
    public String getTrace() {
        return this.trace;
    }

    /**
     * @param bargain 是否成交
     *                1.是 2.否
     */
    @ApiModelProperty("是否成交 1.是 2.否")
    public void setBargain(Integer bargain) {
        this.bargain = bargain;
    }

    /**
     * @return 是否成交
     */
    @ApiModelProperty("是否成交 1.是 2.否")
    public Integer getBargain() {
        return this.bargain;
    }

    /**
     * @param unsubmittedFactor 未成交因素
     */
    @ApiModelProperty("未成交因素")
    public void setUnsubmittedFactor(String unsubmittedFactor) {
        this.unsubmittedFactor = unsubmittedFactor;
    }

    /**
     * @return 未成交因素
     */
    @ApiModelProperty("未成交因素")
    public String getUnsubmittedFactor() {
        return this.unsubmittedFactor;
    }

    /**
     * @param confirm 主管确认记录
     */
    @ApiModelProperty("主管确认记录")
    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    /**
     * @return 主管确认记录
     */
    @ApiModelProperty("主管确认记录")
    public String getConfirm() {
        return this.confirm;
    }

    /**
     * @param remark 备注
     */
    @ApiModelProperty("备注")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return 备注
     */
    @ApiModelProperty("备注")
    public String getRemark() {
        return this.remark;
    }

    /**
     * @param emphasisRests 客户询问重点:其他
     */
    @ApiModelProperty("客户询问重点:其他")
    public void setEmphasisRests(java.lang.String emphasisRests) {
        this.emphasisRests = emphasisRests;
    }

    /**
     * @return 客户询问重点:其他
     */
    @ApiModelProperty("客户询问重点:其他")
    public java.lang.String getEmphasisRests() {
        return this.emphasisRests;
    }

    /**
     * @param clientInaugurationRests 客户就职单位:其他
     */
    @ApiModelProperty("客户就职单位:其他")
    public void setClientInaugurationRests(java.lang.String clientInaugurationRests) {
        this.clientInaugurationRests = clientInaugurationRests;
    }

    /**
     * @return 客户就职单位:其他
     */
    @ApiModelProperty("客户就职单位:其他")
    public java.lang.String getClientInaugurationRests() {
        return this.clientInaugurationRests;
    }

    /**
     * @param unsubmittedFactorRests 未成交因素:其他
     */
    @ApiModelProperty("未成交因素:其他")
    public void setUnsubmittedFactorRests(java.lang.String unsubmittedFactorRests) {
        this.unsubmittedFactorRests = unsubmittedFactorRests;
    }

    /**
     * @return 未成交因素:其他
     */
    @ApiModelProperty("未成交因素:其他")
    public java.lang.String getUnsubmittedFactorRests() {
        return this.unsubmittedFactorRests;
    }
}
