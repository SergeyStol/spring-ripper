package org.example.springripper.bean_factory_post_processor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author sstol
 * 2021-12-11
 */
@SpringBootApplication
public class BFPPAppl {
    public static void main(String... args) {
        SpringApplication.run(BFPPAppl.class, args);
    }

    @Bean
    CommandLineRunner run(OldImpl old) {
        return (args) -> {
            old.sayHello();
        };
    }
}