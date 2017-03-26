package com.starfucker_inc.v1ch07.simpleframe;

import javax.swing.*;
import java.awt.*;

/**
 * swing
 *
 * @author ayorfree
 * @create 2017-03-26-上午11:17
 */

public class SimpleFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimpleFrame frame = new SimpleFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}