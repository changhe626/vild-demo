package com.example.vilddemo.ann;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zk
 * 自定义注解, 进行年纪的判断
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidator.class)  //AgeValidator 这是实现这个注解校验的类
public @interface AgeRange {

    /**
     * 年纪的最大年纪
     *
     * @return
     */
    int min() default 0;


    /**
     * 年纪的最小年纪
     *
     * @return
     */
    int max() default 120;


    /**
     * 默认的错误消息
     *
     * @return
     */
    String message() default "默认-用户年纪不正确";


    /**
     * 分组
     *
     * @return
     */
    Class<?>[] groups() default {};


    /**
     * 负载
     *
     * @return
     */
    Class<? extends Payload>[] payload() default {};


    /**
     * 分组
     * Defines several {@link Enum} annotations on the same element.
     */
    @Documented
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        AgeRange[] value();
    }


}