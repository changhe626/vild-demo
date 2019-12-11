package com.example.vilddemo.exception;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @author zk
 * @Description: 全局异常处理
 * @date 2019年10月29日15:08:35
 */
@RestControllerAdvice
public class ExceptionHandleController {





    /**
     * 处理参数缺失异常
     * 抛出的是 MethodArgumentNotValidException 这个异常
     * @param ex
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JSONObject handleMissParamException(MethodArgumentNotValidException ex) {
        JSONObject obj = new JSONObject();
        obj.put("code", 15000);
        obj.put("msg", ex.getBindingResult().getFieldError().getDefaultMessage());
        obj.put("data", "参数异常");
        ex.printStackTrace();
        System.out.println("发生异常:"+ex.toString());
        return obj;
    }




    @ExceptionHandler(Exception.class)
    public JSONObject handleException(Exception ex) {
        JSONObject obj = new JSONObject();
        obj.put("code", "15000");
        obj.put("msg", "服务内部错误");
        obj.put("data", "");
        ex.printStackTrace();
        System.out.println("发生异常:"+ex.toString());
        return obj;
    }

}