package org.example.springripper.constractorscallsorder;

/**
 * @author sstol
 * 2021-12-11
 */
public class Father {
    {
        System.out.println("Phase 1. Father's instant initializer");
    }

    static {
        System.out.println("Phase -1. Father's static initializer");
    }

    public Father() {
        System.out.println("Phase 2. Father's contractor");
    }
}
