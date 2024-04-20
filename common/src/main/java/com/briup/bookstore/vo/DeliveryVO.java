package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: DeliveryVO
 * @Description: 发货信息对象
 * @Author: songjl
 * @Date: 2023/7/27 09:39
 * @Version: v1.0
 */
@ApiModel("发货信息对象")
@Data
public class DeliveryVO {
    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("快递单号")
    private Integer trackingNumber;

    @ApiModelProperty("配送方式")
    private String distributionMode;
}
