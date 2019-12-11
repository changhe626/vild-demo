package com.example.vilddemo.ann;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义的注解所标记的参数的校验, 这里的Object 实际就是你定义的参数类型,这里可以写Integer, 不用Object强转
 */
public class AgeValidator implements ConstraintValidator<AgeRange, Object> {

    private AgeRange ageRange;
    /**
     * 获取注解中的值, 最小值和最大值
     */
    private int min;
    private int max;


    @Override
    public void initialize(AgeRange constraintAnnotation) {
        //赋值
        ageRange = constraintAnnotation;
        min = ageRange.min();
        max = ageRange.max();
    }


    /**
     * 这里的value 就是 int 的value值,前端传递了300来, 这里就是300
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        int age = (int) value;
        //只有在年纪是小于1 大于120的时候才校验
        if (age < min || age > max) {
            //禁用默认的消息提示
            context.disableDefaultConstraintViolation();
            //设置提示语, 获取注解中的提示语
            context.buildConstraintViolationWithTemplate(ageRange.message()).addConstraintViolation();
            return false;
        }
        //return true 不进行校验.
        return true;
    }
}
