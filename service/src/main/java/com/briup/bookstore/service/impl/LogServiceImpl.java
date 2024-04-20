package com.briup.bookstore.service.impl;

import com.briup.bookstore.mapper.LogMapper;
import com.briup.bookstore.po.Log;
import com.briup.bookstore.po.ext.BookExtend;
import com.briup.bookstore.service.LogService;
import com.briup.bookstore.utils.BeanCopyUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public PageInfo getLogPage(Integer pageNum, Integer pageSize, String username) {
        //开始分页
        PageHelper.startPage(pageNum,pageSize);
        //对应查询
        List<Log> logs = logMapper.selectAllLogByUsername(username);
        PageInfo<Log> pages = new PageInfo<Log>(logs);
        return pages;
    }

    @Override
    public void deleteLog(String ids) {
        String[] split = ids.split(",");
        for (String string : split) {
            logMapper.deleteBatchIds(string);
        }
    }
}
