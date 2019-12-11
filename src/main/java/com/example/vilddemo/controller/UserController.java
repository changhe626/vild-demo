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

    /**
     *
     单个参数校验

     @ RestController
     @ Validated
     public class PingController {

     @ GetMapping("/getUser")
     public String getUserStr(@ NotNull(message = "name 不能为空") String name,
                              @ Max(value = 99, message = "不能大于99岁") Integer age) {

            return "name: " + name + " ,age:" + age;
     }
     }
     当处理GET请求时或只传入少量参数的时候，我们可能不会建一个bean来接收这些参数，就可以像上面这样直接在controller方法的参数中进行校验。
     注意：这里一定要在方法所在的controller类上加入@Validated注解，不然没有任何效果。
     *
     */


    /**
     * 参数校验分组
     * 级联参数校验
     *
     * https://www.cnblogs.com/mooba/p/11276062.html
     */


}
