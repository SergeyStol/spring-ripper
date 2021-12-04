package org.example.springripper.profiling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Appl {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(Appl.class, args);
        MyInterface bean = run.getBean(MyInterface.class);
        for (int i = 0; i < 10; i++) {
            bean.foo();
            Thread.sleep(1000);
        }
    }
}