package org.example.springripper.bean_factory_post_processor;

import org.springframework.stereotype.Component;

/**
 * @author sstol
 * 2021-12-11
 */
public class NewImpl extends OldImpl {
    @Override
    public void sayHello() {
        System.out.println("I am a new impl");
    }
}
