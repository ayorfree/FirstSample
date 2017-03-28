package com.starfucker_inc.v1ch14.bounceThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ayorfree
 * @create 2017-03-28-上午9:02
 */

public class Bounce {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new BounceFrame();
                frame.setTitle("BallBounce");
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
    private static final int STEPS = 1000;
    private static final int DELAY = 3;

    public BallRunnable(Ball ball,Component component)
    {
        this.ball = ball;
        this.component = component;
    }

    public void run()
    {
        try {
            for (int i = 1; i <= STEPS ; i++) {
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
        comp = new BallComponent();
        add(comp, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        addButton(comp, "Start", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBall();
            }
        });
        addButton(comp, "Close", new ActionListener() {
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
        JButton button= new JButton(title);
        c.add(button);
        button.addActionListener(listener);
    }

    public void addBall()
    {
        Ball ball = new Ball();
        comp.add(ball);
        Runnable r = new BallRunnable(ball, comp);
        Thread t = new Thread(r);
        t.start();
    }
}
