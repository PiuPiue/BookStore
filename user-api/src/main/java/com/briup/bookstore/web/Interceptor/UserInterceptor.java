package com.briup.bookstore.web.Interceptor;

import com.briup.bookstore.exception.BookStoreException;
import com.briup.bookstore.utils.JsonWebTokenUtils;
import io.jsonwebtoken.Claims;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS"))
            return true;
        System.out.println("拦截器生效");
        //验证用户是否登录
        //在请求当中是否携带了门票(token)
        String token = request.getHeader("token");
        if(token==null){
            throw new BookStoreException(1001,"未携带token");
        }
        try {
            Claims claims = JsonWebTokenUtils.parseJWT(token);
            //保存userId
            String userId = claims.getSubject();
            request.setAttribute("userId",userId);
        } catch (Exception e) {
            throw new BookStoreException(1002,"token无效");
        }
        //验证门票是否为真
        return true;
    }

}
