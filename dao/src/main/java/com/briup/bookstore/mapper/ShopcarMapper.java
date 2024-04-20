package com.briup.bookstore.mapper;


import com.briup.bookstore.po.Shopcar;
import com.briup.bookstore.po.ext.ShopCarExtend;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_shopcar】的数据库操作Mapper
* @createDate 2023-07-18 21:33:38
* @Entity com.briup.bookstore.po.Shopcar
*/
@Repository
public interface ShopcarMapper{
//    查询用户的购物车信息
    List<ShopCarExtend> findByUserId( @Param("id") Integer userId);
//查看用户是否已经对书籍添加购物车
    Shopcar findByUserIdAndBookId(@Param("userId")Integer userId, @Param("bookId") Integer bookId);
//    修改购物车数量
    void updateNumById(@Param("num") Integer num,@Param("id") Integer id);
//    新增购物车
    void  save(@Param("userId") Integer userId,@Param("bookId") Integer bookId);
//    删除购物车信息
    void  deleteById(@Param("id") Integer id);

    Shopcar findById(@Param("id")Integer id);

    void deleteByUserId(String uid);

    void deleteByBookId(Integer id);
}




