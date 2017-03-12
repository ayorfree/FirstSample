package com.starfucker_inc.v1ch05.anonymousInnerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrate anonymous inner class
 * @version 3.12.2017
 * @author ayorfree
 */
public class AnoymousInnerClassTest {
    public static void main(String[] args)
    {
        TalkingClock clock = new TalkingClock();
        clock.start(1000,true);

        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */

class TalkingClock
{
    /**
     * @param intervals the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
     */
    public void start(int intervals, final boolean beep)
    {
        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                Date now = new Date();
                System.out.println("beep time is " + now);
                if (beep) Toolkit.getDefaultToolkit().beep();
            }
        };
        Timer t = new Timer(intervals, listener);
        t.start();
    }
}
