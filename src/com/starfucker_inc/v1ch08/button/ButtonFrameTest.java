package com.starfucker_inc.v1ch08.button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrameTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                ButtonFrame frame = new ButtonFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ButtonFrame extends JFrame
{
    private JPanel buttonPanel;

    public ButtonFrame(){
        buttonPanel = new JPanel();
        add(buttonPanel);

        makeButton("Yellow" , Color.YELLOW);
        makeButton("Green", Color.GREEN);
        makeButton("Pink", Color.PINK);
        makeButton("Blue", Color.BLUE);

    }

    public void makeButton(String name, final Color backgroundColor)
    {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(backgroundColor);
            }
        });
    }
}