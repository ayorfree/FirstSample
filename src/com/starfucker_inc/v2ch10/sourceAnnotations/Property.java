package com.starfucker_inc.v2ch10.sourceAnnotations;

/**
 * @author ayorfree
 * @create 2017-10-13-下午1:25
 */

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Property {
    String editor() default "";
}
