package com.atguigu.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author lq
 * @create 2021-07-10-10:13
 */
@ResponseStatus(value= HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException {
    public UserTooManyException(){

    }
    public UserTooManyException(String message){
        super(message);
    }
}
