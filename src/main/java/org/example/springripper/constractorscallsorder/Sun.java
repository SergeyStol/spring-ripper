package org.example.springripper.constractorscallsorder;

/**
 * @author sstol
 * 2021-12-11
 */
public class Sun extends Father {
    {
        System.out.println("Phase 3. Sun's instant initializer");
    }

    static {
        System.out.println("Phase 0. Sun's static initializer");
    }

    public Sun() {
        super();
        System.out.println("Phase 4. Sun's constructor");
    }
}
