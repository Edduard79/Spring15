package com.example.Ex15;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Order(1)
public class LegacyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String userAgent = request.getHeader("User-Agent");
        if(userAgent != null && (userAgent.contains("Mozilla") || userAgent.contains("Opera") || userAgent.contains("Edg"))){
            response.setStatus(HttpStatus.GONE.value());
            response.getWriter().write("This is just old code");
            return false;
        }
        return true;
    }

}
