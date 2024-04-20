package com.briup.bookstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author briup-adam
 * @Date 2023/7/28 下午3:55
 * @Description
 **/


@Data
@ApiModel("订单支付成功数据传输对象")
public class OrderPaySuccessDTO {
    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("支付时间")
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    private LocalDateTime payDate;

    @ApiModelProperty("支付方式 目前只支持 支付宝支付")
    private String payWay;

}
