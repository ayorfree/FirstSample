package com.starfucker_inc.v2ch06.splitPane;

/**
 * @author ayorfree
 * @create 2017-10-10-下午3:18
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * This frame consists of two nested split panes to demonstrate planet images and data.
 */
public class SplitPaneFrame extends JFrame
{
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 300;

    private Planet[] planets = { new Planet("Mercury", 2440, 0), new Planet("Venus", 6052, 0),
            new Planet("Earth", 6378, 1), new Planet("Mars", 3397, 2),
            new Planet("Jupiter", 71492, 16), new Planet("Saturn", 60268, 18),
            new Planet("Uranus", 25559, 17), new Planet("Neptune", 24766, 8),
            new Planet("Pluto", 1137, 1), };

    public SplitPaneFrame()
    {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // set up components for planet names, images, descriptions

        final JList<Planet> planetList = new JList<>(planets);
        final JLabel planetImage = new JLabel();
        final JTextArea planetDescription = new JTextArea();

        planetList.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent event)
            {
                Planet value = (Planet) planetList.getSelectedValue();

                // update image and description

                planetImage.setIcon(value.getImage());
                planetDescription.setText(value.getDescription());
            }
        });

        // set up split panes

        JSplitPane innerPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, planetList, planetImage);

        innerPane.setContinuousLayout(true);
        innerPane.setOneTouchExpandable(true);

        JSplitPane outerPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, innerPane,
                planetDescription);

        add(outerPane, BorderLayout.CENTER);
    }
}

class SplitPaneTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new SplitPaneFrame();
                frame.setTitle("SplitPaneTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class Planet
{
    private String name;
    private double radius;
    private int moons;
    private ImageIcon image;

    /**
     * Constructs a planet.
     * @param n the planet name
     * @param r the planet radius
     * @param m the number of moons
     */
    public Planet(String n, double r, int m)
    {
        name = n;
        radius = r;
        moons = m;
        image = new ImageIcon(getClass().getResource(name + ".gif"));
    }

    public String toString()
    {
        return name;
    }

    /**
     * Gets a description of the planet.
     * @return the description
     */
    public String getDescription()
    {
        return "Radius: " + radius + "\nMoons: " + moons + "\n";
    }

    /**
     * Gets an image of the planet.
     * @return the image
     */
    public ImageIcon getImage()
    {
        return image;
    }
}
