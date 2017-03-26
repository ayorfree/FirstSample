package com.testing.just_testing.innerclass_callback_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
/**
 * test5 匿名内部类参数化
 * @author ayorfree
 * @create 2017-03-26-下午9:00
 */

public class Test5 {
    public static void main(String[] args)
    {
        TalkingClock3 clock3 = new TalkingClock3();
        clock3.start(1000, true);

        JOptionPane.showMessageDialog(null, "off?");
        System.exit(0);
    }
}

class TalkingClock3
{
    public void start(int interval, final boolean beep)
    {
        Timer timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("beep is " + new Date());
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        });
        timer.start();
    }
}
