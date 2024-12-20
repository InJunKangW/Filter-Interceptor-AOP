package com.example.filterinterceptoraop.exception;

public class ExamInterceptorException extends RuntimeException {
    public ExamInterceptorException(String timing) {
        super(String.format("interceptor exception while %s", timing));
    }
}
