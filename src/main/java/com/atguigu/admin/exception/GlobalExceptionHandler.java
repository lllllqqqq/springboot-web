package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 出了整个web controller的异常
 * @author lq
 * @create 2021-07-10-10:00
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class}) //处理异常
    public String handleArithException(Exception e){
        log.error("异常是：{}",e);
        return "login"; //视图地址
    }
}
