package com.digiwes.demo.ann.mgt.edmann;

import java.lang.annotation.*;

/**
 * Created by liurl3 on 2016/3/31.
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
@Documented
public @interface EDMProperty {
    Class<?> value();
}
