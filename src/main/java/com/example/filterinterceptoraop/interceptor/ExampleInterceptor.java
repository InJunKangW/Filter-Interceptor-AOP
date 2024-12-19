package com.example.filterinterceptoraop.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class ExampleInterceptor implements HandlerInterceptor {
    // controller 로 보내기 전에 처리하는 인터셉터
    // 반환이 false라면 controller로 요청을 넘기지 않음
    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
             Object obj) throws Exception {
        log.error("ExampleInterceptor preHandle");
        return true;
    }

    // controller의 handler가 끝나면 처리됨
    @Override
    public void postHandle(
            @NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
             Object obj,  ModelAndView mav)
            throws Exception {
        log.error("ExampleInterceptor postHandle");
    }

    // view까지 처리가 끝난 후에 처리됨
    @Override
    public void afterCompletion(
            @NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
             Object obj,  Exception e)
            throws Exception {
        log.error("ExampleInterceptor afterCompletion");
    }
}
