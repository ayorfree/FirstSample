package com.testing.just_testing.innerclass_callback_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * test3 局部内部类
 * @author ayorfree
 * @create 2017-03-26-下午8:41
 */

public class Test3 {
    public static void main(String[] args) {
        TalkingClock1 clock1 = new TalkingClock1();
        clock1.start(1000, true);

        JOptionPane.showMessageDialog(null, "ok?");
        System.exit(0);
    }
}
class TalkingClock1 {

    public void start(int interval, final boolean beep)
    {
        class TimePrinter implements ActionListener
        {
            public void actionPerformed(ActionEvent event){
                Date now = new Date();
                System.out.println("beep time is" + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        }
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(interval, listener);
        timer.start();
    }
}
