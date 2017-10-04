package com.starfucker_inc.v2ch03.inetAddress;

import java.io.IOException;
import java.net.InetAddress;

/**
 * @author ayorfree
 * @create 2017-10-04-上午9:04
 */

public class InetAddressTest
{
    public static void main(String[] args) throws IOException
    {
        if (args.length > 0)
        {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses)
            {
                System.out.println(a);
            }
        }
        else
        {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
