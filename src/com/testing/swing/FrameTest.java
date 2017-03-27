package com.testing.swing;

import javax.swing.*;
import java.awt.*;

/**
 * for concurrency
 *
 * @author ayorfree
 * @create 2017-03-27-上午11:17
 */

public class FrameTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Frame frame = new Frame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true   );
            }
        });
    }
}

class Frame extends JFrame
{
    private static final int DEFAULT_WIDTH = 200;
    private static final int DEFAULT_HEIGHT = 300;

    public Frame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
