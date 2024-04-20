package com.briup.bookstore.web.controller;

import com.briup.bookstore.annotation.SystemLog;
import com.briup.bookstore.response.Result;
import com.briup.bookstore.service.ShopCarService;
import com.briup.bookstore.vo.ShopCarVO;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/shopCar")
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService;

    @PutMapping("/{id}")
    @SystemLog(businessName = "加入购物车")
    public Result addIntoShopCar(@PathVariable Integer id, HttpServletRequest request){
        String userId = (String) request.getAttribute("userId");
        shopCarService.add(Integer.parseInt(userId), id);
        return Result.success();
    }

    @GetMapping()
    @SystemLog(businessName = "展示购物车")
    public Result showCar(HttpServletRequest request){
        String userId = (String)request.getAttribute("userId");
        List<ShopCarVO> lists = shopCarService.findLists(Integer.valueOf(userId));
        return Result.success(lists);
    }

    @PutMapping("/{id1}/{id2}")
    @SystemLog(businessName = "添加数量")
    public Result updateNum(@PathVariable Integer id1,@PathVariable Integer id2){
        shopCarService.updateNum(id1,id2);
        return Result.success();
    }

    @DeleteMapping
    @SystemLog(businessName = "删除购物车")
    public Result deleteCar(@RequestBody Integer... integers){
        shopCarService.deleteByIds(integers);
        return Result.success();
    }


}
