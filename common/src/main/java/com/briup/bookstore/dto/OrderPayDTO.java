package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/28 下午2:11
 * @Description
 **/
@Data
@ApiModel("订单支付数据传输对象")
public class OrderPayDTO {
    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("订单总额")
    private String totalPrice;

    @ApiModelProperty("成功后回调地址")
    private String pathUrl;

}
