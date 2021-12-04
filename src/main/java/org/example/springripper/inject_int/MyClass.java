package org.example.springripper.inject_int;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyClass implements MyInterface {
    @InjectNumber(number = 777)
    private int repeat;

    @PostConstruct
    void init() {
        System.out.println(repeat);
    }
}