package com.briup.bookstore.service;

import com.briup.bookstore.vo.CollectVO;

import java.util.List;

/**
 * @Author briup-adam
 * @Date 2023/7/26 上午9:08
 * @Description
 **/

public interface CollectService {
    List<CollectVO> findCollects(Integer userId);

    void  addCollect(Integer userId,Integer bookId);

    void   deleteCollect(Integer ... id);
}
