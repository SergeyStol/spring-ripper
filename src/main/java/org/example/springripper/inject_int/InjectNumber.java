package org.example.springripper.inject_int;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface InjectNumber {
    int number();
}
