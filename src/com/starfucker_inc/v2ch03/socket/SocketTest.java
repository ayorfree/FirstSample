package com.starfucker_inc.v2ch03.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-10-04-上午8:51
 */

public class SocketTest
{
    public static void main(String[] args) throws IOException
    {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13))
        {
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner(inStream);

            while (in.hasNextLine())
            {
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }

}
