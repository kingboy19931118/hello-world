package com.arbor.note.poi;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * POI根据列明解析pojo对象的注解
 * {@link BasePoiDTO}
 *
 * @author qiaomu.wang
 * @date 2018-09-10
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface TakeoutPoi {

    String name() default "";
}
