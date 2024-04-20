package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/26 下午5:31
 * @Description
 **/
@ApiModel("收货地址详细信息展示对象")
@Data
public class AddressVO {

    @ApiModelProperty("收货地址ID")
    private Integer id;


    @ApiModelProperty("收件人姓名")
    private String receiverName;


    @ApiModelProperty("省市区地址")
    private String urbanAddr;


    @ApiModelProperty("详细地址")
    private String detailAddr;


    @ApiModelProperty("收件人电话")
    private String phone;

    @ApiModelProperty("是否默认")
    private  boolean defaultValue;

}
