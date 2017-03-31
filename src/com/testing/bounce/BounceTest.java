package com.testing.bounce;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * @author ayorfree
 * @create 2017-03-31-下午8:52
 */

public class BounceTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BallRunnable implements Runnable
{
    private Ball ball;
    private Component component;
    private final int STEPS = 1000;
    private final int DELAY = 5;

    public BallRunnable(Ball ball, Component component)
    {
        this.ball = ball;
        this.component = component;
    }

    public void run()
    {
        try {
            for (int i = 1; i <= STEPS; i++) {
                ball.move(component.getBounds());
                component.repaint();
                Thread.sleep(DELAY);
            }
        }
        catch (InterruptedException e)
        {
        }
    }
}

class BounceFrame extends JFrame
{
    private BallComponent comp;

    public BounceFrame()
    {
        setTitle("T.A.S.T.E");
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        addButton(buttonPanel, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });

        addButton(buttonPanel, "Close", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }

    public void addButton(Container c, String title, ActionListener listener)
    {
        JButton button = new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall()
    {
        Ball ball = new Ball();
        comp.add(ball);
        BallRunnable r = new BallRunnable(ball, comp);
        Thread t = new Thread(r);
        t.start();
    }
}

class Ball
{
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dx = 1;
    private double dy = 1;

    public void move(Rectangle2D bounds)
    {
        x += dx;
        y += dy;

        if (x < bounds.getMinX())
        {
            x = bounds.getMinX();
            dx = -dx;
        }
        if (x + XSIZE >= bounds.getMaxX())
        {
            x = bounds.getMaxX() -XSIZE;
            dx = -dx;
        }
        if (y < bounds.getMinY())
        {
            y = bounds.getMinY();
            dy = -dy;
        }
        if (y + YSIZE >= bounds.getMaxY())
        {
            x = bounds.getMaxY() -YSIZE;
            dy = -dy;
        }
    }

    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}

class BallComponent extends JPanel
{
    private ArrayList<Ball> balls = new ArrayList<>();
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    public void add(Ball ball)
    {
        balls.add(ball);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Ball ball:
             balls) {
            g2.fill(ball.getShape());
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}