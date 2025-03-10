package com.briup.bookstore.mapper;

import com.briup.bookstore.po.Log;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_log】的数据库操作Mapper
* @createDate 2023-07-23 13:38:30
* @Entity com.briup.bookstore.po.Log
*/
public interface LogMapper {

    /**
     * @Author qinyc
     * @Description 插入日志
     * @Version: v1.0
     * @Date 18:55 2023/7/23
     * @Param :logPO
     * @Return: void
     **/
    void insertLog(Log logPO);

    /**
     * @Author qinyc
     * @Description 默认查询全部日志信息，当用户名存在的情况下，需要按照用户名进行模糊查询
     * @Version: v1.0
     * @Date 9:14 2023/7/25
     * @Param :username
     * @Return: java.util.List<com.briup.bookstore.po.Log>
     **/
    List<Log> selectAllLogByUsername(String username);

    /**
     * @Author qinyc
     * @Description 批量删除
     * @Version: v1.0
     * @Date 9:06 2023/7/26
     * @Param :ids
     * @Return: void
     **/
    void deleteBatchIds(String ids);
}