package com.example.filterinterceptoraop.aop;

import com.example.filterinterceptoraop.exception.ExamAOPException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExampleAOP {

    //어노테이션을 지정할 경우 패키지 다 써야 한다(import 문 복붙하면 된다)
    @Around(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.error("AOP start");

        //원래 매서드 실행
        Object result = joinPoint.proceed();

        log.error("AOP end");
//        throw new ExamAOPException();
        return result;
    }
}
