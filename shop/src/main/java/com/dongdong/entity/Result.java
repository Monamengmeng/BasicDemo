package com.dongdong.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Mona
 * @date 2020/6/3 16:42
 */
@Data
public class Result implements Serializable {
    private boolean success;//是否chenggon
    private String message;//返回信息

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
