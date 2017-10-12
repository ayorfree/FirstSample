package com.starfucker_inc.v2ch08.filePicker;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;

/**
 * @author ayorfree
 * @create 2017-10-11-上午10:49
 */

public class FilePickerBean extends JPanel {
    private static final int XPREFSIZE = 200;
    private static final int YPREFSIZE = 20;

    private JButton dialogButton;
    private JTextField nameField;
    private JFileChooser chooser;
    private String[] extensions = {"gif", "png"};

    public FilePickerBean() {
        dialogButton = new JButton("...");
        nameField = new JTextField(30);

        chooser = new JFileChooser();
        setPreferredSize(new Dimension(XPREFSIZE, YPREFSIZE));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 100;
        gbc.weighty = 100;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        add(nameField, gbc);

        dialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setFileFilter(new FileNameExtensionFilter(Arrays.toString(extensions), extensions));
                int r = chooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    File f = chooser.getSelectedFile();
                    String name = f.getAbsolutePath();
                    setFilename(name);
                }
            }
        });
        nameField.setEditable(false);

        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        add(dialogButton, gbc);
    }

    public void setFilename(String newValue) {
        String oldvValue = nameField.getText();
        nameField.setText(newValue);
        firePropertyChange("fileName", oldvValue, newValue);
    }

    public String getFileName() {
        return nameField.getText();
    }

    public String[] getExtensions() {
        return extensions;
    }

    public void setExtensions(String[] newValue) {
        extensions = newValue;
    }

    public String getExtensions(int i) {
        if (0 <= i && i < extensions.length) return extensions[i];
        else return "";
    }

    public void setExtensions(int i, String newValue) {
        if (0 <= i && i < extensions.length) extensions[i] = newValue;
    }
}
