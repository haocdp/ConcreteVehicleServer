package com.hbjy.carlocation.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminAuthInteceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Long adminId = (Long) session.getAttribute("adminId");
        if (session != null) {
            if (adminId != null) {
                return true;
            }
            else{
                response.setStatus(401);
                return false;
            }
        } else {
            response.setStatus(400);
           return false;
        }
    }
}

