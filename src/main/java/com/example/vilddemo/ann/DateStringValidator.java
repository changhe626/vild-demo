package com.example.vilddemo.ann;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;


/**
 * 日期格式的具体校验规则. 示例2
 */
public class DateStringValidator implements ConstraintValidator<DateString, String> {


    private boolean allowBlank;
    private String dataFormat = "yyyy-MM-dd HH:mm:ss";
    private String message;


    @Override
    public void initialize(DateString constraintAnnotation) {
        allowBlank = constraintAnnotation.allowBlank();
        dataFormat = constraintAnnotation.format();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!allowBlank && value != null && value.trim().length() == dataFormat.length()) {
            try {
                // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
                SimpleDateFormat format = new SimpleDateFormat(dataFormat);
                // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
                format.setLenient(false);
                format.parse(value);
                return true;
            } catch (Exception e) {
                //重定义错误模板
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
                return false;
            }
        }
        return true;
    }
    /**
     * 第二种加载错误信息：
     在resource 目录下新建提示信息配置文件“ValidationMessages.properties“。名字必须为“ValidationMessages.properties“
     因为SpringBoot自动读取classpath中的ValidationMessages.properties里的错误信息。
     ValidationMessages.properties 文件的编码为ASCII。
     内容：date.str=issuTime时间格式有误，要求时间格式：yyyy-MM-dd HH:mm:ss
     */


}
