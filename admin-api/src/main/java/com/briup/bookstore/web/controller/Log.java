package com.briup.bookstore.web.controller;

import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.LogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class Log {

    @Autowired
    private LogService logService;

    @GetMapping("/getLogPage")
    public Result getLogPage(Integer pageNum,Integer pageSize,String username){
        PageInfo logPage = logService.getLogPage(pageNum, pageSize, username);
        return Result.success(logPage);
    }

    @DeleteMapping("/deleteLog/{ids}")
    public Result deleteLog(@PathVariable String ids){
        logService.deleteLog(ids);
        return Result.success();
    }

}
