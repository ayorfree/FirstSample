package com.starfucker_inc.v2ch07.renderQuality;

/**
 * @author ayorfree
 * @create 2017-10-10-下午4:08
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * This program demonstrates the effect of the various rendering hints.
 * @version 1.10 2007-08-16
 * @author Cay Horstmann
 */
public class RenderQualityTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new RenderQualityTestFrame();
                frame.setTitle("RenderQualityTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

class RenderQualityTestFrame extends JFrame
{
    private RenderQualityComponent canvas;
    private JPanel buttonBox;
    private RenderingHints hints;
    private int r;

    public RenderQualityTestFrame()
    {
        buttonBox = new JPanel();
        buttonBox.setLayout(new GridBagLayout());
        hints = new RenderingHints(null);

        makeButtons("KEY_ANTIALIASING", "VALUE_ANTIALIAS_OFF", "VALUE_ANTIALIAS_ON");
        makeButtons("KEY_TEXT_ANTIALIASING", "VALUE_TEXT_ANTIALIAS_OFF", "VALUE_TEXT_ANTIALIAS_ON");
        makeButtons("KEY_FRACTIONALMETRICS", "VALUE_FRACTIONALMETRICS_OFF",
                "VALUE_FRACTIONALMETRICS_ON");
        makeButtons("KEY_RENDERING", "VALUE_RENDER_SPEED", "VALUE_RENDER_QUALITY");
        makeButtons("KEY_STROKE_CONTROL", "VALUE_STROKE_PURE", "VALUE_STROKE_NORMALIZE");
        canvas = new RenderQualityComponent();
        canvas.setRenderingHints(hints);

        add(canvas, BorderLayout.CENTER);
        add(buttonBox, BorderLayout.NORTH);
        pack();
    }

    /**
     * Makes a set of buttons for a rendering hint key and values.
     * @param key the key name
     * @param value1 the name of the first value for the key
     * @param value2 the name of the second value for the key
     */
    void makeButtons(String key, String value1, String value2)
    {
        try
        {
            final RenderingHints.Key k = (RenderingHints.Key) RenderingHints.class.getField(key).get(
                    null);
            final Object v1 = RenderingHints.class.getField(value1).get(null);
            final Object v2 = RenderingHints.class.getField(value2).get(null);
            JLabel label = new JLabel(key);

            buttonBox.add(label, new GBC(0, r).setAnchor(GBC.WEST));
            ButtonGroup group = new ButtonGroup();
            JRadioButton b1 = new JRadioButton(value1, true);

            buttonBox.add(b1, new GBC(1, r).setAnchor(GBC.WEST));
            group.add(b1);
            b1.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    hints.put(k, v1);
                    canvas.setRenderingHints(hints);
                }
            });
            JRadioButton b2 = new JRadioButton(value2, false);

            buttonBox.add(b2, new GBC(2, r).setAnchor(GBC.WEST));
            group.add(b2);
            b2.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent event)
                {
                    hints.put(k, v2);
                    canvas.setRenderingHints(hints);
                }
            });
            hints.put(k, v1);
            r++;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

/**
 * This component produces a drawing that shows the effect of rendering hints.
 */
class RenderQualityComponent extends JComponent
{
    private static final int DEFAULT_WIDTH = 750;
    private static final int DEFAULT_HEIGHT = 150;

    private RenderingHints hints = new RenderingHints(null);
    private Image image;

    public RenderQualityComponent()
    {
        image = new ImageIcon(getClass().getResource("face.gif")).getImage();
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHints(hints);

        g2.draw(new Ellipse2D.Double(10, 10, 60, 50));
        g2.setFont(new Font("Serif", Font.ITALIC, 40));
        g2.drawString("Hello", 75, 50);

        g2.draw(new Rectangle2D.Double(200, 10, 40, 40));
        g2.draw(new Line2D.Double(201, 11, 239, 49));

        g2.drawImage(image, 250, 10, 100, 100, null);
    }

    /**
     * Sets the hints and repaints.
     * @param h the rendering hints
     */
    public void setRenderingHints(RenderingHints h)
    {
        hints = h;
        repaint();
    }

    public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}

class GBC extends GridBagConstraints
{
    /**
     Constructs a GBC with a given gridx and gridy position and
     all other grid bag constraint values set to the default.
     @param gridx the gridx position
     @param gridy the gridy position
     */
    public GBC(int gridx, int gridy)
    {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    /**
     Constructs a GBC with given gridx, gridy, gridwidth, gridheight
     and all other grid bag constraint values set to the default.
     @param gridx the gridx position
     @param gridy the gridy position
     @param gridwidth the cell span in x-direction
     @param gridheight the cell span in y-direction
     */
    public GBC(int gridx, int gridy, int gridwidth, int gridheight)
    {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    /**
     Sets the anchor.
     @param anchor the anchor value
     @return this object for further modification
     */
    public GBC setAnchor(int anchor)
    {
        this.anchor = anchor;
        return this;
    }

    /**
     Sets the fill direction.
     @param fill the fill direction
     @return this object for further modification
     */
    public GBC setFill(int fill)
    {
        this.fill = fill;
        return this;
    }

    /**
     Sets the cell weights.
     @param weightx the cell weight in x-direction
     @param weighty the cell weight in y-direction
     @return this object for further modification
     */
    public GBC setWeight(double weightx, double weighty)
    {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }

    /**
     Sets the insets of this cell.
     @param distance the spacing to use in all directions
     @return this object for further modification
     */
    public GBC setInsets(int distance)
    {
        this.insets = new Insets(distance, distance, distance, distance);
        return this;
    }

    /**
     Sets the insets of this cell.
     @param top the spacing to use on top
     @param left the spacing to use to the left
     @param bottom the spacing to use on the bottom
     @param right the spacing to use to the right
     @return this object for further modification
     */
    public GBC setInsets(int top, int left, int bottom, int right)
    {
        this.insets = new Insets(top, left, bottom, right);
        return this;
    }

    /**
     Sets the internal padding
     @param ipadx the internal padding in x-direction
     @param ipady the internal padding in y-direction
     @return this object for further modification
     */
    public GBC setIpad(int ipadx, int ipady)
    {
        this.ipadx = ipadx;
        this.ipady = ipady;
        return this;
    }
}
