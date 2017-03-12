package com.starfucker_inc.v1ch05.timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Created by zhangjiyun on 2017/3/11.
 */
public class TimerTest
{
    public static void main(String[] args)
    {
        ActionListener listener = new TimerPrinter();
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit?");
        System.exit(0);
    }
}

class TimerPrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        Date now = new Date();
        System.out.println("beep time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
