package com.testing.just_testing;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * for callback test
 *
 * @author ayorfree
 * @create 2017-03-26-下午6:04
 */

public class TimerTest
{
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}

class TalkingClock
{
    private int interva;
    private boolean beep;

    public TalkingClock(int interva, boolean beep)
    {
        this.interva = interva;
        this.beep = beep;
    }

    public void start()
    {
        ActionListener listener = new TimerPrinter();
        Timer timer = new Timer(interva, listener);
        timer.start();
    }

    class TimerPrinter implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            Date now = new Date();
            System.out.println("beep is now +" + now);
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}