package org.example.springripper.screensaver.solution1_inject_ctx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sstol
 * 2021-12-11
 */
@Component
public class ColorFrame extends JFrame {

    @Autowired
    ApplicationContext ctx;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        setLocation(random.nextInt(1200), random.nextInt(800));
        getContentPane().setBackground(ctx.getBean(Color.class));
        repaint();
    }
}