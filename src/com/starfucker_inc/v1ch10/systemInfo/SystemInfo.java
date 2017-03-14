package com.starfucker_inc.v1ch10.systemInfo;

/**
 * Created by zhangjiyun on 2017/3/14.
 */
import java.io.*;
import java.util.*;

/**
 * This program prints out all system properties.
 * @version 1.10 2002-07-06
 * @author Cay Horstmann
 */
public class SystemInfo
{
    public static void main(String[] args)
    {
        try
        {
            Properties sysprops = System.getProperties();
            sysprops.store(System.out, "System Properties");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
