package com.digiwes.demo.ann.mgt.edmann;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liurl3 on 2016/4/5.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface EDMKeyProperty {
    String value();
}
