package org.example.springripper.contextlistener;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author sstol
 * 2021-12-11
 */
@Component
public class SomeBean {

    private String name = "default";

    {
        System.out.println("Phase 0. Instant initialization");
        System.out.println("name=" + name);
    }

    public SomeBean() {
        this.name = "class constructor";
        System.out.println("Phase1. Class constructor");
        System.out.println("name=" + name);
    }

    @PostConstruct
    void init() {
        System.out.println("Phase2. PostConstruct");
    }

    @PostProxy
    void contextListener() {
        System.out.println("Phase3. ContextListener");
    }
}