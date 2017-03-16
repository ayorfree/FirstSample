package com.testing.just_testing;

import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 2017.3.16
 * @author  ayorfree
 */
public class JustTesting
{
    public static void main(String[] args)
    {
        Locale.setDefault(Locale.UK);
        //Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().info("File->Open menu item selected");

    }
}
