package com.starfucker_inc.v2ch03.sever;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author ayorfree
 * @create 2017-10-04-上午9:14
 */

public class EchoServer
{
    public static void main(String[] args) throws IOException
    {
        try (ServerSocket s = new ServerSocket(8189))
        {
            try (Socket incoming = s.accept())
            {
                InputStream inStream = incoming.getInputStream();
                OutputStream outStream = incoming.getOutputStream();

                try (Scanner in = new Scanner(inStream))
                {
                    PrintWriter out  = new PrintWriter(outStream, true /* autoFlush */);

                    out.println("Hello! Enter Bye to exit.");

                    boolean done = false;
                    while (!done && in.hasNextLine())
                    {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) done = true;
                    }
                }
            }
        }
    }
}
