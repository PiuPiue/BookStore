package com.briup.bookstore.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @ClassName: BookSearchDTO
 * @Description: TODO
 * @Author: songjl
 * @Date: 2023/7/27 14:07
 * @Version: v1.0
 */
@ApiModel("图书查询DTO")
@Data
public class BookSearchDTO {

    @ApiModelProperty("查询关键字")
    private String query;

    @ApiModelProperty("分类编号")
    private Integer categoryId;

}
