package com.testing.just_testing.innerclass_callback_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * test2 回调与内部类
 * @author ayorfree
 * @create 2017-03-26-下午8:34
 */

public class Test2 {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "shut up?");
        System.exit(0);
    }
}

class TalkingClock{
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
        Timer timer = new Timer(interval, listener);
        timer.start();
    }

    class TimePrinter implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            Date now = new Date();
            System.out.println("beep time is " + now);
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}
