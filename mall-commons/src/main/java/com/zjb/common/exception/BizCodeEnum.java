package com.zjb.common.exception;

/**
 * @ClassName BizCodeEnum
 * @Description 错误编码和错误信息的枚举类
 * @Author zhengjiabin
 * @Date 2022/6/30 16:27
 * @Version 1.0
 **/
public enum  BizCodeEnum {

    UNKNOW_EXCEPTION(10000,"系统未知异常"),
    VALID_EXCEPTION(10001,"参数格式异常");

    private int code;
    private String msg;

    BizCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
