package cn.ydimall.recharge.cmcc.system.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * created by zhongruhang on 2017/12/19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 系统异常处理，比如：404,500
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e) {
        String page;
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            page = "404";
        } else {
            page = "500";
        }
        return page;
    }
}
