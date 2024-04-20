package com.briup.bookstore.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName: PageUtils
 * @Description: 分页工具类，解决分页插件无法对封装的数据进行分页的问题
 * @Author: songjl
 * @Date: 2023/7/25 10:55
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("分页工具类")
public class PageUtils<T> {
    @ApiModelProperty("当前页码")
    private Integer pageNum;
    @ApiModelProperty("每页显示条数")
    private Integer pageSize;

    @ApiModelProperty("要分页显示的数据集合")
    private List<T> dataList; // 总数据集合

    /**
     * 获取当前页的数据
     * @return 当前页的数据
     */
    public List<T> getCurrentPageData() {
        // 计算当前页开始的索引
        int startIndex = (pageNum - 1) * pageSize;
        // 计算当前页结束的索引
        int endIndex = Math.min(startIndex + pageSize, dataList.size());
        return dataList.subList(startIndex, endIndex);
    }

}