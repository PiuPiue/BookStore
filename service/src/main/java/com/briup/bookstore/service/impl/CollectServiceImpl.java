package com.briup.bookstore.service.impl;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.mapper.CollectMapper;
import com.briup.bookstore.po.ext.CollectExtend;
import com.briup.bookstore.service.CollectService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.briup.bookstore.vo.CollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public List<CollectVO> findCollects(Integer userId) {
        List<CollectExtend> collectByUserId = collectMapper.findCollectByUserId(userId);
        List<CollectVO>list = new ArrayList<>();
        for (CollectExtend collectExtend:collectByUserId){
            CollectVO collectVO = BeanCopyUtils.copyBean(collectExtend, CollectVO.class);
            list.add(collectVO);
        }
        return list;
    }

    @Override
    public void addCollect(Integer userId, Integer bookId) {
        collectMapper.save(userId,bookId);
    }

    @Override
    public void deleteCollect(Integer... ids) {
        for (Integer id : ids) {
            collectMapper.deleteById(id);
        }
    }

}
