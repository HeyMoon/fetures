package com.dyh.transaction.api.annotation;

import java.lang.annotation.*;

/**
 * Created by dengyunhui on 2017/12/4 21:15.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TransactionProcess {
}
