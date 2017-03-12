package com.starfucker_inc.v1ch05.innerClass;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classes.
 * @version
 * @author
 */
public class innerClass
{
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock(10000,true);
        clock.start();

        JOptionPane.showMessageDialog(null, "X?");
        System.exit(0);
    }
}

class TalkingClock
{
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    public void start()
    {
        ActionListener listener = new TimePrinter();
        Timer t = new Timer(interval, listener);
        t.start();
    }

    class TimePrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Date now  = new Date();
            System.out.println("the beep time is " + now);
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}