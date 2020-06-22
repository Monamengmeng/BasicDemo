package com.dongdong.exception;

/**
 * 异常分类的枚举类
 *
 * @author Mona
 * @date 2020/6/5 17:38
 */
public enum ExceptionType {
    USER_INPUT_ERROR(400,"用户输入异常"),
    SYSTEM_ERROR(500,"系统服务异常"),
    OTHER_ERROR(999,"其它未知异常"),

    LDD(11,"kk");

//    public static final String  USER_DDD = new String("df");

    ExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    private String typeDesc;//异常类型中文描述
    private int code;//code

    public String getTypeDesc() {
        return typeDesc;
    }

    public int getCode() {
        return code;
    }



}
