package com.briup.bookstore.service;

import com.briup.bookstore.vo.ShopCarVO;

import java.util.List;

/**
* @author qinyc
* @description 针对表【es_shopcar】的数据库操作Service
* @createDate 2023-07-18 21:33:38
*/
public interface ShopCarService {

    List<ShopCarVO> findLists(Integer userId);

    void add(int userId, Integer bookId);

    void updateNum(Integer id,Integer num);

    void  deleteByIds(Integer... ids);
}
