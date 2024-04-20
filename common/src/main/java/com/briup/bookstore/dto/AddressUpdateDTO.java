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
@ApiModel("修改收货地址数据传输对象")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressUpdateDTO {

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
}
