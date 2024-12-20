package com.example.filterinterceptoraop.filter;

import com.example.filterinterceptoraop.exception.ExamFilterException;
import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;

@Slf4j
public class ExampleFilter implements Filter {
    //어플리케이션이 실행 될 때 최초로 한 번만 실행됨.
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.error("ExampleFilter init");
        Filter.super.init(filterConfig);
    }


    // Filter 인터페이스를 구현 시  필수적으로 구현해야 함 (init, destroy 는 구현하지 않아도 됨)
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.error("ExampleFilter doFilter start");

        /*
            호출 안하면 계속 응답 대기 상태가 됨
            왜냐하면 모든 필터를 거쳐야 요청을 Dispatcher Servlet 에 전달 하게 되는데
            Spring 기본으로 지니는 필터를 거치지 못하게 되니 전달을 못하게 된 상태로 응답이 머무르게 됨.
         */
        filterChain.doFilter(servletRequest, servletResponse);
//        throw new ExamFilterException();

        log.error("ExampleFilter doFilter end");
    }

    //어플리케이션이 종료 될 때 최초로 한 번만 실행됨.
    @Override
    public void destroy() {
        log.error("ExampleFilter destroy");
        Filter.super.destroy();
    }
}
