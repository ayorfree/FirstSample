package com.starfucker_inc.v2ch05.collation;

/**
 * @author ayorfree
 * @create 2017-10-10-上午9:59
 */

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.util.List;

import javax.swing.*;

/**
 * This program demonstrates collating strings under various locales.
 * @version 1.14 2012-01-26
 * @author Cay Horstmann
 */
public class CollationTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                JFrame frame = new CollationFrame();
                frame.setTitle("CollationTest");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

/**
 * This frame contains combo boxes to pick a locale, collation strength and decomposition rules, a
 * text field and button to add new strings, and a text area to list the collated strings.
 */
class CollationFrame extends JFrame
{
    private Collator collator = Collator.getInstance(Locale.getDefault());
    private List<String> strings = new ArrayList<>();
    private Collator currentCollator;
    private Locale[] locales;
    private JComboBox<String> localeCombo = new JComboBox<>();
    private JTextField newWord = new JTextField(20);
    private JTextArea sortedWords = new JTextArea(20, 20);
    private JButton addButton = new JButton("Add");
    private EnumCombo strengthCombo = new EnumCombo(Collator.class, "Primary",
            "Secondary", "Tertiary", "Identical");
    private EnumCombo decompositionCombo = new EnumCombo(Collator.class,
            "Canonical Decomposition", "Full Decomposition", "No Decomposition");

    public CollationFrame()
    {
        setLayout(new GridBagLayout());
        add(new JLabel("Locale"), new GBC(0, 0).setAnchor(GBC.EAST));
        add(new JLabel("Strength"), new GBC(0, 1).setAnchor(GBC.EAST));
        add(new JLabel("Decomposition"), new GBC(0, 2).setAnchor(GBC.EAST));
        add(addButton, new GBC(0, 3).setAnchor(GBC.EAST));
        add(localeCombo, new GBC(1, 0).setAnchor(GBC.WEST));
        add(strengthCombo, new GBC(1, 1).setAnchor(GBC.WEST));
        add(decompositionCombo, new GBC(1, 2).setAnchor(GBC.WEST));
        add(newWord, new GBC(1, 3).setFill(GBC.HORIZONTAL));
        add(new JScrollPane(sortedWords), new GBC(0, 4, 2, 1).setFill(GBC.BOTH));

        locales = (Locale[]) Collator.getAvailableLocales().clone();
        Arrays.sort(locales, new Comparator<Locale>()
        {

            public int compare(Locale l1, Locale l2)
            {
                return collator.compare(l1.getDisplayName(), l2.getDisplayName());
            }
        });
        for (Locale loc : locales)
            localeCombo.addItem(loc.getDisplayName());
        localeCombo.setSelectedItem(Locale.getDefault().getDisplayName());

        strings.add("America");
        strings.add("able");
        strings.add("Zulu");
        strings.add("zebra");
        strings.add("\u00C5ngstr\u00F6m");
        strings.add("A\u030angstro\u0308m");
        strings.add("Angstrom");
        strings.add("Able");
        strings.add("office");
        strings.add("o\uFB03ce");
        strings.add("Java\u2122");
        strings.add("JavaTM");
        updateDisplay();

        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                strings.add(newWord.getText());
                updateDisplay();
            }
        });

        ActionListener listener = new ActionListener()
        {
            public void actionPerformed(ActionEvent event)
            {
                updateDisplay();
            }
        };

        localeCombo.addActionListener(listener);
        strengthCombo.addActionListener(listener);
        decompositionCombo.addActionListener(listener);
        pack();
    }

    /**
     * Updates the display and collates the strings according to the user settings.
     */
    public void updateDisplay()
    {
        Locale currentLocale = locales[localeCombo.getSelectedIndex()];
        localeCombo.setLocale(currentLocale);

        currentCollator = Collator.getInstance(currentLocale);
        currentCollator.setStrength(strengthCombo.getValue());
        currentCollator.setDecomposition(decompositionCombo.getValue());

        Collections.sort(strings, currentCollator);

        sortedWords.setText("");
        for (int i = 0; i < strings.size(); i++)
        {
            String s = strings.get(i);
            if (i > 0 && currentCollator.compare(s, strings.get(i - 1)) == 0) sortedWords
                    .append("= ");
            sortedWords.append(s + "\n");
        }
        pack();
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

class EnumCombo extends JComboBox<String>
{
    private Map<String, Integer> table = new TreeMap<>();

    /**
     Constructs an EnumCombo.
     @param cl a class
     @param labels an array of static field names of cl
     */
    public EnumCombo(Class<?> cl, String... labels)
    {
        for (String label : labels)
        {
            String name = label.toUpperCase().replace(' ', '_');
            int value = 0;
            try
            {
                java.lang.reflect.Field f = cl.getField(name);
                value = f.getInt(cl);
            }
            catch (Exception e)
            {
                label = "(" + label + ")";
            }
            table.put(label, value);
            addItem(label);
        }
        setSelectedItem(labels[0]);
    }

    /**
     Returns the value of the field that the user selected.
     @return the static field value
     */
    public int getValue()
    {
        return table.get(getSelectedItem());
    }
}
