package com.ze.common;

import com.ze.bean.Result;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一处理异常
 */
@RestControllerAdvice
public class ExceptionAdaptController {

    /**
     * 运行异常捕获
     */
    @ExceptionHandler({RuntimeException.class})
    public Result runtimeException(RuntimeException exception) {
        exception.printStackTrace();
        return Result.error(exception.getMessage());
    }

    /**
     * @Validated注解异常捕获
     */
    @ExceptionHandler({BindException.class})
    public Result validExceptionHandler(BindException exception) {
        return Result.error(exception.getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 其他异常捕获
     */
    @ExceptionHandler({Exception.class})
    public Result exception(Exception exception) {
        exception.printStackTrace();
        return Result.error(exception.getMessage());
    }
}
