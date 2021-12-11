package org.example.springripper.bean_factory_post_processor;

import org.springframework.stereotype.Component;

/**
 * @author sstol
 * 2021-12-11
 */
@Component
@DeprecatedClass(newImpl = NewImpl.class)
public class OldImpl {
    public void sayHello() {
        System.out.println("I am an old class");
    }
}