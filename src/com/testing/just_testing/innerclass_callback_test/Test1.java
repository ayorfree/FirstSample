package com.testing.just_testing.innerclass_callback_test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;


/**
 * test1 回调
 * @author ayorfree
 * @create 2017-03-26-下午8:27
 */

public class Test1 {
    public static void main(String[] args)
    {
        ActionListener listener = new TimePrinter();
        Timer timer = new Timer(1000, listener);
        timer.start();

        JOptionPane.showMessageDialog(null, "Quit？");
        System.exit(0);
    }
}

class TimePrinter implements ActionListener
{
    public void actionPerformed(ActionEvent event)
    {
        Date now = new Date();
        System.out.println("beep time is " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
