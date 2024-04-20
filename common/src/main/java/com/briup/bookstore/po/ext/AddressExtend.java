package com.briup.bookstore.po.ext;

import com.briup.bookstore.po.Address;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/27 上午10:23
 * @Description
 **/

@Data
@ApiModel("收货地址拓展类")
public class AddressExtend extends Address {
    @ApiModelProperty("是否为默认的收货地址")
    private boolean defaultValue;
}
