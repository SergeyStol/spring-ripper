package org.example.springripper.screensaver_new_scope;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author sstol
 * 2021-12-11
 */
public abstract class ColorFrame extends JFrame {
    public ColorFrame() {
        setSize(200, 200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void showOnRandomPlace() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        setLocation(random.nextInt(1200), random.nextInt(800));
        getContentPane().setBackground(getColor());
        repaint();
    }

    protected abstract Color getColor();
}