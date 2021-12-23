package org.example.springripper.screensaver.solution2_proxy_mode;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Color color;

    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        setLocation(random.nextInt(1200), random.nextInt(800));
        getContentPane().setBackground(color);
        repaint();
    }
}