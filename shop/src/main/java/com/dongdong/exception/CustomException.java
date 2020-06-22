package com.dongdong.exception;

/**
 * @author Mona
 * @date 2020/6/5 17:44
 */
public class CustomException extends RuntimeException {
    //异常错误编码
    private int code;
    //异常信息
    private String message;

    private CustomException() {};//私有化这个构造函数

    public CustomException (ExceptionType exceptionTypeEnum) {
        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getTypeDesc();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
