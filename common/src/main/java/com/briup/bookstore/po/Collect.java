package com.briup.bookstore.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author briup-adam
 * @Date 2023/7/26 下午2:09
 * @Description
 **/
@ApiModel("收藏实体类")
@Data
@Accessors(chain = true)
public class Collect {
    @ApiModelProperty("收藏编号")
    private  Integer id;
    @ApiModelProperty("用户编号")
    private Integer userId;
    @ApiModelProperty("书籍编号")
    private  Integer bookId;
}
