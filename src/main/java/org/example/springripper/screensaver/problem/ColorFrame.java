package org.example.springripper.screensaver.problem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * @author sstol
 * 2021-12-11
 */
@Component
public class ColorFrame extends JFrame {
    @Autowired
    private Color color;
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