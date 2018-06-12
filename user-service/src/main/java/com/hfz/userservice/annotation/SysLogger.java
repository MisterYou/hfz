package com.hfz.userservice.annotation;

import java.lang.annotation.*;

/**
 * Created by youjin on 2018/7/12.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLogger {
    String value() default "";
}
