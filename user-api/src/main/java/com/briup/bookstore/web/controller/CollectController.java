package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.CollectService;
import com.briup.bookstore.vo.CollectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;


    @PostMapping("/{id}")
    @SystemLog(businessName = "添加收藏")
    public Result addCollect(@PathVariable Integer id,HttpServletRequest request){
        String userId = (String)request.getAttribute("userId");
        collectService.addCollect(Integer.valueOf(userId),id);
        return Result.success();
    }


    @GetMapping ("")
    @SystemLog(businessName = "查找收藏内容")
    public Result findCollect(HttpServletRequest request) {
        String userId = (String)request.getAttribute("userId");
        List<CollectVO> list =  collectService.findCollects(Integer.valueOf(userId));
        return Result.success(list);
    }

    @DeleteMapping
    public Result deleteCollect(@RequestBody Integer ...ids){
        collectService.deleteCollect(ids);
        return Result.success();
    }

}
