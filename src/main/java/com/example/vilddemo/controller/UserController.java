package com.example.vilddemo.controller;


import com.example.vilddemo.entity.User;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class UserController {


    /**
     * 对单个参数进行校验
     * @param name
     * @return
     */
    @GetMapping("hi1")
    public String singleParam(@RequestParam("name") @NotNull(message = "名字不能为空") String name){
        return "success";
    }


    /**
     * 对一个实体类的各个属性进行校验.
     *
     * 两个注解的区别: https://blog.csdn.net/qq_27680317/article/details/79970590
     @ Validated：用在方法入参上无法单独提供嵌套验证功能。不能用在成员属性（字段）上，
     也无法提示框架进行嵌套验证。能配合嵌套验证注解@Valid进行嵌套验证。

     @ Valid：用在方法入参上无法单独提供嵌套验证功能。能够用在成员属性（字段）上，
     提示验证框架进行嵌套验证。能配合嵌套验证注解@Valid进行嵌套验证。

     * @param user
     * @return
     */
    @PostMapping("hi2")
    public String beanParam(@RequestBody @Validated User user){
    //public String beanParam(@RequestBody @Valid User user){
        System.out.println(user.toString());
        return "success";
    }


}
