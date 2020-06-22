package com.dongdong.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Mona
 *
 * 全局异常处理
 *
 * @date 2020/6/5 18:21
 */
@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public AjaxResponse customeExcetion(CustomException e) {
        if(e.getCode() == ExceptionType.SYSTEM_ERROR.getCode()) {
            //400异常不需要持久化，讲异常信息以友好的方式告知用户就可以
            //TODO 将异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public AjaxResponse exception(Exception e) {
        //TODO 将异常信息持久化处理，方便运维人员处理

//        try {
//        }catch (CustomException e) {
//            if(e.getCode() == ExceptionType.SYSTEM_ERROR.getCode()) {
//                //400异常不需要持久化，讲异常信息以友好的方式告知用户就可以
//                //TODO 将异常信息持久化处理，方便运维人员处理
//            }
//            return AjaxResponse.error(e);
//        }catch (Exception e) {
//            return AjaxResponse.error(new CustomException(ExceptionType.OTHER_ERROR,"未知异常"));
//        }


        //没有被程序员发现，并转换为CustomException的异常，都是其它异常或者未知异常
        return AjaxResponse.error(new CustomException(ExceptionType.OTHER_ERROR));





    }



}
