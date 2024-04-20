package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author briup-adam
 * @Date 2023/7/26 下午5:09
 * @Description
 **/
@ApiModel("新增收获地址传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressAddDTO {

    @ApiModelProperty("客户id")
    private  Integer userId;

    @ApiModelProperty("收件人姓名")
    private String receiverName;


    @ApiModelProperty("省市区地址")
    private String urbanAddr;


    @ApiModelProperty("详细地址")
    private String detailAddr;


    @ApiModelProperty("收件人电话")
    private String phone;
}
