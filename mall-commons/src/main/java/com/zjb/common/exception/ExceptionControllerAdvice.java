package com.zjb.common.exception;

import com.zjb.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @ClassName ExceptionControllerAdvice
 * @Description 统一的异常处理类
 * @Author zhengjiabin
 * @Date 2022/6/30 16:35
 * @Version 1.0
 **/
@Slf4j
@RestControllerAdvice(basePackages = "com.zjb.mall.product.controller")
public class ExceptionControllerAdvice {

    /**
     * @author zhengjiabin
     * @description 处理验证异常方法
     * @date 2022/6/30 16:49
     * @param e
     * @return com.zjb.common.utils.R
     **/
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handlerValidExecption(MethodArgumentNotValidException e){
        HashMap<String, String> map = new HashMap<>();
        e.getFieldErrors().forEach((fieldError) ->{
            map.put(fieldError.getField(),fieldError.getDefaultMessage());
                });
        return R.error(BizCodeEnum.VALID_EXCEPTION.getCode(),BizCodeEnum.VALID_EXCEPTION.getMsg()).put("data",map);
    }

    @ExceptionHandler(Throwable.class)
    public R handlerExecption(Throwable throwable){
        log.error("错误信息: ",throwable);
        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(),BizCodeEnum.UNKNOW_EXCEPTION.getMsg()).put("data",throwable.getMessage());
    }
}
