package com.example.vilddemo.entity;


import com.example.vilddemo.ann.AgeRange;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 @ NotNull
不能为null，但是可以为空字符串""

 @ NotEmpty
 不能为null，不能为空字符串""，其本质是CharSequence, Collection, Map, or Array的size或者length不能为0

 @ NotBlank
 a constrained String is valid as long as it’s not null and the trimmed length is greater than zero

 @ NonNull
 @ NotNull 是 JSR303（Bean的校验框架）的注解，用于运行时检查一个属性是否为空，如果为空则不合法。
 @ NonNull 是JSR 305（缺陷检查框架）的注解，是告诉编译器这个域不可能为空，当代码检查有空值时会给出一个风险警告，目前这个注解只有IDEA支持。
 */

@Data
public class User {


    @NotNull(message = "id不能为空")
    private Integer id;


    /**
     * 对于字符串的校验,最好同时使用这个两个注解
     */
    @NotNull(message = "名字不能为空")  //被注释的元素必须不为 null
    @NotBlank(message = "名字不能为空") //可以使用了  验证字符串非null，且长度必须大于0
    private String name;

    /**
     * 对于邮箱的校验, 首先是判断是否为空,在判断格式
     */
    @NotBlank(message = "邮箱不能为空")
    @NotNull(message = "邮箱不能为空")
    @Email(message = "邮箱格式错误")
    private String email;


    @Max(value = 200, message = "最大值为200")
    @Min(value = 10, message = "最小值是10")
    private int money;


    @NotNull(message = "手机号不能为空")
    @NotBlank(message = "手机号不能为空")
    //  貌似这里的校验有问题, 建议在代码中进行手机号的校验, 更加灵活
    //@Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    //@Max(value = 11, message = "手机号只能为11位")
    //@Min(value = 11, message = "手机号只能为11位")
    private String mobileNo;


    /**
     * 这里使用自定义的注解
     * 全部注解
     */
    @AgeRange(min = 10, max = 20, message = "用户年纪不正确")
    private int age;


    /**
     * 这里使用自定义的注解
     * 只有最小值,使用默认最大值
     */
    @AgeRange(min = 10, message = "用户年纪2不正确")
    private int age2;


}
