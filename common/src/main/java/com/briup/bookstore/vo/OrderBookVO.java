package com.briup.bookstore.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: OrderBookVO
 * @Description: TODO
 * @Author: songjl
 * @Date: 2023/7/26 10:16
 * @Version: v1.0
 */
@ApiModel("每个订单包含的图书对象")
@Data
public class OrderBookVO {
    @ApiModelProperty("图书编号")
    private Integer bookId;

    @ApiModelProperty("图书名称")
    private String name;

    @ApiModelProperty("图书封面")
    private String cover;

    @ApiModelProperty("图书价格")
    private Double price;

    @ApiModelProperty("图书数量")
    private Integer num;

    @ApiModelProperty("小记")
    private BigDecimal totalPrice;
}
