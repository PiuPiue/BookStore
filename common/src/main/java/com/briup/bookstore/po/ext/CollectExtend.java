package com.briup.bookstore.po.ext;

import com.briup.bookstore.po.Collect;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author briup-adam
 * @Date 2023/7/26 下午2:09
 * @Description
 **/

@Data
@ApiModel("收藏信息拓展类")
public class CollectExtend extends Collect {
    @ApiModelProperty("图书名称")
    private String name;


    @ApiModelProperty("图书封面图片")
    private String cover;



    @ApiModelProperty("图书价格")
    private Double price;


}
