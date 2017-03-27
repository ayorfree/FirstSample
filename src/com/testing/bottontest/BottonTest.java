package com.testing.bottontest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * test
 *
 * @author ayorfree
 * @create 2017-03-26-下午9:49
 */

public class BottonTest {
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                BottonFrame frame = new BottonFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class BottonFrame extends JFrame
{
    private JPanel bottonPanel;

    public BottonFrame(){
        bottonPanel = new JPanel();
        add(bottonPanel);

        makeButton("Yellow", Color.YELLOW);
        makeButton("Red", Color.RED);
        makeButton("Blue", Color.BLUE);
}
    public void makeButton(String name, final Color backgroundColor)
    {
        Button button = new Button(name);
        bottonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bottonPanel.setBackground(backgroundColor);
            }
        });
    }
}
