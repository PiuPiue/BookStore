package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: OrderDeliveryDTO
 * @Description: 订单发货信息DTO
 * @Author: songjl
 * @Date: 2023/7/27 14:11
 * @Version: v1.0
 */
@ApiModel("订单发货信息DTO")
@Data
public class OrderDeliveryDTO {
    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("快递单号")
    private Integer trackingNumber;

    @ApiModelProperty("配送方式")
    private String distributionMode;
}
