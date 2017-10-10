package com.starfucker_inc.v2ch05.numberFormat;

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;

/**
 * This program demonstrates formatting numbers under various locales.
 * @version 1.13 2007-07-25
 * @author Cay Horstmann
 */
public class NumberFormatTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new NumberFormatFrame();
                frame.setTitle("NumberFormatTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains radio buttons to select a number format, a combo box to pick a locale, a text
 * field to display a formatted number, and a button to parse the text field contents.
 */
class NumberFormatFrame extends JFrame
{
    private Locale[] locales;
    private double currentNumber;
    private JComboBox<String> localeCombo = new JComboBox<>();
    private JButton parseButton = new JButton("Parse");
    private JTextField numberText = new JTextField(30);
    private JRadioButton numberRadioButton = new JRadioButton("Number");
    private JRadioButton currencyRadioButton = new JRadioButton("Currency");
    private JRadioButton percentRadioButton = new JRadioButton("Percent");
    private ButtonGroup rbGroup = new ButtonGroup();
    private NumberFormat currentNumberFormat;

    public NumberFormatFrame()
    {
        setLayout(new GridBagLayout());

        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                updateDisplay();
            }
        };

        JPanel p = new JPanel();
        addRadioButton(p, numberRadioButton, rbGroup, listener);
        addRadioButton(p, currencyRadioButton, rbGroup, listener);
        addRadioButton(p, percentRadioButton, rbGroup, listener);

        add(new JLabel("Locale:"), new GBC(0, 0).setAnchor(GBC.EAST));
        add(p, new GBC(1, 1));
        add(parseButton, new GBC(0, 2).setInsets(2));
        add(localeCombo, new GBC(1, 0).setAnchor(GBC.WEST));
        add(numberText, new GBC(1, 2).setFill(GBC.HORIZONTAL));
        locales = (Locale[]) NumberFormat.getAvailableLocales().clone();
        Arrays.sort(locales, new Comparator<Locale>()
        {
            public int compare(Locale l1, Locale l2)
            {
                return l1.getDisplayName().compareTo(l2.getDisplayName());
            }
        });
        for (Locale loc : locales)
            localeCombo.addItem(loc.getDisplayName());
        localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());
        currentNumber = 123456.78;
        updateDisplay();

        localeCombo.addActionListener(listener);

        parseButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                String s = numberText.getText().trim();
                try
                {
                    Number n = currentNumberFormat.parse(s);
                    if (n != null)
                    {
                        currentNumber = n.doubleValue();
                        updateDisplay();
                    }
                    else
                    {
                        numberText.setText("Parse error: " + s);
                    }
                }
                catch (ParseException e)
                {
                    numberText.setText("Parse error: " + s);
                }
            }
        });
        pack();
    }

    /**
     * Adds a radio button to a container.
     * @param p the container into which to place the button
     * @param b the button
     * @param g the button group
     * @param listener the button listener
     */
    public void addRadioButton(Container p, JRadioButton b, ButtonGroup g, ActionListener listener)
    {
        b.setSelected(g.getButtonCount() == 0);
        b.addActionListener(listener);
        g.add(b);
        p.add(b);
    }

    /**
     * Updates the display and formats the number according to the user settings.
     */
    public void updateDisplay()
    {
        Locale currentLocale = locales[localeCombo.getSelectedIndex()];
        currentNumberFormat = null;
        if (numberRadioButton.isSelected()) currentNumberFormat = NumberFormat
                .getNumberInstance(currentLocale);
        else if (currencyRadioButton.isSelected()) currentNumberFormat = NumberFormat
                .getCurrencyInstance(currentLocale);
        else if (percentRadioButton.isSelected()) currentNumberFormat = NumberFormat
                .getPercentInstance(currentLocale);
        String n = currentNumberFormat.format(currentNumber);
        numberText.setText(n);
    }
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