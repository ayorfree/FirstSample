package com.testing.just_testing.innerclass_callback_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * test4 局部匿名内部类
 * @author ayorfree
 * @create 2017-03-26-下午8:52
 */

public class Test4 {
    public static void main(String[] args)
    {
        TalkingClock2 clock2 = new TalkingClock2();
        clock2.start(1000, true);

        JOptionPane.showMessageDialog(null, "okkkkk");
        System.exit(0);
    }
}

class TalkingClock2
{
    public void start(int interval, final boolean beep)
    {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date now = new Date();
                System.out.println("beep time is  " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };

        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
