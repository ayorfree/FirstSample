package com.starfucker_inc.v1ch14.bounceThread;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * @author ayorfree
 * @create 2017-03-28-上午8:54
 */

public class BallComponent extends JPanel{
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    private java.util.List<Ball> balls = new ArrayList<>();

    public void add(Ball ball)
    {
        balls.add(ball);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball ball :
                balls) {
            g2.fill(ball.getShape());
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
