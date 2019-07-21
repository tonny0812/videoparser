package com.keepgulp.common.annotations;

import com.keepgulp.common.constants.ColumnType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityColumn {
    /**
     * 是否为序列号
     * @return
     */
    boolean id() default false;
    /**
     * 字段名称
     * @return
     */
    String name() default "";

    /**
     * 字段类型
     * @return
     */
    ColumnType type() default ColumnType.STRING;
}
