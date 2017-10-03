package com.starfucker_inc.v2ch02.stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.net.URL;

/**
 * @author ayorfree
 * @create 2017-10-03-上午10:44
 */

public class StAXTest
{
    public static void main(String[] args) throws Exception
    {
        String urlString;
        if (args.length == 0)
        {
            urlString = "http://www.w3c.org";
            System.out.println("Using " + urlString);
        }
        else urlString = args[0];
        URL url = new URL(urlString);
        InputStream in = url.openStream();
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(in);
        while (parser.hasNext())
        {
            int event = parser.next();
            if (event == XMLStreamReader.START_ELEMENT)
            {
                if (parser.getLocalName().equals("a"))
                {
                    String href = parser.getAttributeValue(null, "href");
                    if (href != null)
                        System.out.println(href);
                }
            }
        }
    }
}
