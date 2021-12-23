package org.example.springripper.bean_factory_post_processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author sstol
 * 2021-12-11
 */
@Component
@DeprecatedClass(newImpl = NewImpl.class)
public class OldImpl {
    @Autowired
    LocalDate localDate;
    public void sayHello() {
        System.out.println("I am an old class");
    }
}