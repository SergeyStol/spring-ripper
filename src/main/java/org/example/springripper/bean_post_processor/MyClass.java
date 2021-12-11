package org.example.springripper.bean_post_processor;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profiling
public class MyClass implements MyInterface {
    private String str;

    public MyClass() {
        this.str = "Hello";
        System.out.println("Constructor");
    }

    @PostConstruct
    void init() {
        System.out.println("PostConstruct");
    }

    @Override
    public void foo() {
        System.out.println("foooooooo");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}