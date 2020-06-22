package com.dongdong.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mona
 * @date 2020/6/5 18:00
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AjaxResponse {
    private boolean isok;
    private int code;
    private String message;
    private Object data;

    //请求出现异常时的响应数据封装
    public static AjaxResponse error(CustomException e) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        if(e.getCode() == ExceptionType.USER_INPUT_ERROR.getCode()) {
            resultBean.setMessage(e.getMessage());
        }else if(e.getCode() == ExceptionType.SYSTEM_ERROR.getCode()) {
            resultBean.setMessage(e.getMessage() + ", 导致系统出现异常，请联系管理员电话：1234444XX进行处理！");
        }else {
            resultBean.setMessage(("系统出现未知异常，请联系管理员电话1234444XX进行处理！"));
        }
        return resultBean;
    }

    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success!");
        resultBean.setData(data);
        return resultBean;
    }
}
