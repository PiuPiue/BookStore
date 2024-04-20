package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: OrderSearchDTO
 * @Description: 订单查询条件DTO
 * @Author: songjl
 * @Date: 2023/7/27 14:08
 * @Version: v1.0
 */
@ApiModel("订单查询条件DTO")
@Data
public class OrderSearchDTO {

    @ApiModelProperty("订单编号")
    private String id;

    @ApiModelProperty("订单状态 1.已创建未支付 2.已支付未发货 3.已发货未收货 4.已收货 5.已关闭 只能关闭 已创建未支付的订单")
    private Integer status;

}
