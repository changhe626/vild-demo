package com.example.vilddemo.ann;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author zhangke
 * 日期格式的校验  示例2
 */
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateStringValidator.class)
@Documented
public @interface DateString {

    String message() default "时间格式有误，要求时间格式：yyyy-MM-dd HH:mm:ss";

    String format() default "yyyy-MM-dd HH:mm:ss";

    boolean allowBlank() default false;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
