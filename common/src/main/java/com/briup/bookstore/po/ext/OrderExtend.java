package com.briup.bookstore.po.ext;

import com.briup.bookstore.po.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/7/27 下午5:04
 * @Description
 **/

@Data
@ApiModel("订单信息拓展类")
public class OrderExtend extends Order {

    @ApiModelProperty("订单编号")
    private String orderId;

    @ApiModelProperty("图书信息")
    private List<OrderItemExtend> orderItems;

    @ApiModelProperty("订单金额")
    private BigDecimal totalPrice=BigDecimal.ZERO;

    @ApiModelProperty("订单商品数")
    private  Integer totalNum=0;

    @ApiModelProperty("下单用户名")
    private String username;

    public void  genPrice(){
        for (OrderItemExtend item : orderItems) {
            item.setTotalPrice(multiplication(item.getNum(),item.getPrice()));
            totalPrice=totalPrice.add(item.getTotalPrice());
            totalNum+=item.getNum();
        }
    }
    private  BigDecimal  multiplication(Integer num,Double price){
       return BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(price));
    }

}
