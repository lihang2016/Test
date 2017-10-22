package com.example.exception;

import com.example.dto.SingleResponse;
import com.example.dto.ViewInfo;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义全局异常
 * Created by 96230 on 2017/5/29.
 */
@ControllerAdvice
@ResponseBody
public class CommonExceptionAdvice {
    private static Logger logger = LoggerFactory.getLogger(CommonExceptionAdvice.class);
    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(CPBusinessException.class)
    public ViewInfo handleServiceException(CPBusinessException e) {
        logger.error("业务逻辑异常", e);
        return ViewInfo.from(new SingleResponse().failure(e.getMessage(),e.getCode()));
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ViewInfo runtimeException(RuntimeException e) {
        logger.error("业务逻辑异常", e);
        return ViewInfo.from(new SingleResponse().failure("内部错误",500));
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ViewInfo runtimeException(Exception e) {
        logger.error("业务逻辑异常", e);
        return ViewInfo.from(new SingleResponse().failure("内部错误",500));
    }

    /**
     * 500 - Internal Server Error
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnauthorizedException.class)
    public ViewInfo runtimeException(UnauthorizedException e) {
        logger.error("业务逻辑异常", e);
        return ViewInfo.from(new SingleResponse().failure("没有权限",500));
    }

}
