package org.example.springripper.property_file_appl_ctx;

/**
 * @author sstol
 * 2021-12-11
 */
public class MyBean implements MyInterface {
    public String message;

    @Override
    public void sayMessage() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
