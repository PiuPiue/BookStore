package com.briup.bookstore.po.ext;

import com.briup.bookstore.po.OrderItem;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author briup-adam
 * @Date 2023/7/27 下午5:24
 * @Description
 **/
@ApiModel("订单项拓展类")
@Data
public class OrderItemExtend extends OrderItem {

    @ApiModelProperty("图书名称")
    private String name;

    @ApiModelProperty("图书封面")
    private String cover;

    @ApiModelProperty("图书价格")
    private Double price;


    @ApiModelProperty("小记")
    private BigDecimal totalPrice;
}
