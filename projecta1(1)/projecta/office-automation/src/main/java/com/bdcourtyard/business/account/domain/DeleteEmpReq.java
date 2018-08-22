package com.bdcourtyard.business.account.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: xiayanxin
 * @Date: 2018-07-16 19:42
 * @Description:
 */
public class DeleteEmpReq {

    private String empIds;

    @ApiModelProperty("部门ID,多个中间用逗号隔开")
    public String getEmpIds() {
        return empIds;
    }

    @ApiModelProperty("部门ID,多个中间用逗号隔开")
    public void setEmpIds(String empIds) {
        this.empIds = empIds;
    }

    @Override
    public String toString() {
        return "DeleteEmpReq{" +
                "empIds='" + empIds + '\'' +
                '}';
    }
}
