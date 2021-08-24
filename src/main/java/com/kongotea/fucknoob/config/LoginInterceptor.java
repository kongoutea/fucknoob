package com.kongotea.fucknoob.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆拦截
        if(request.getSession().getAttribute("username") == null) {
            request.setAttribute("msg","请先登录哦");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }
        else{
            return true;
        }
    }
}
