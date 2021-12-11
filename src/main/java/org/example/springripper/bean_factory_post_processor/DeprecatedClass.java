package org.example.springripper.bean_factory_post_processor;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author sstol
 * 2021-12-11
 */
@Retention(RUNTIME)
public @interface DeprecatedClass {
    Class<?> newImpl();
}