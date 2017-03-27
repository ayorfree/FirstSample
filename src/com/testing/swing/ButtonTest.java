package com.testing.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * for fun
 *
 * @author ayorfree
 * @create 2017-03-27-下午4:01
 */

public class ButtonTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new ButtonFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class ButtonFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private JPanel buttonPanel;

    public ButtonFrame()
    {
        buttonPanel = new JPanel();
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        add(buttonPanel);

        addButton("Yellow", Color.YELLOW);
        addButton("Red", Color.RED);
        addButton("Black", Color.BLACK);
    }

    public void addButton(String name, Color backgroundColor)
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
