package com.example.filterinterceptoraop.config;


import com.example.filterinterceptoraop.interceptor.ExampleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ExampleInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ExampleInterceptor())
                .addPathPatterns("/**") // 적용할 url
                .excludePathPatterns("/other/**"); //적용을 제외할 url. 둘이 충돌 시 우선함
    }
}
