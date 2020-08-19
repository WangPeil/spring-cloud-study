package com.example.advice;

import com.example.pojo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangpeil
 */
@ResponseBody
@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public CommonResult<Object> handlerException(Exception e) {
        log.info("系统内部异常", e);
        return new CommonResult<>(500, "fail");
    }
}
