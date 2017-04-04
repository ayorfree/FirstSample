package com.starfucker_inc.v2ch01.match;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author ayorfree
 * @create 2017-04-04-上午9:47
 */

public class HrefMatch {
    public static void main(String[] args){
        try {
            String urlString;
            if (args.length > 0) urlString = args[0];
            else urlString = "https://www.douban.com/people/coilectif/";

            InputStreamReader in = new InputStreamReader(new URL(urlString).openStream());

            StringBuilder input = new StringBuilder();
            int ch;
            while ((ch = in.read()) != -1)
                input.append((char) ch);

            String patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"| [^\\s>]*)\\s*>";
            Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(input);
            ArrayList<String> matches = new ArrayList<>();
            PrintWriter out = new PrintWriter("douban.txt", "UTF-8");
            int n = 0;

            while (matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                String match = input.substring(start, end);
                n++;
                System.out.println(match);
                System.out.println(n);
                matches.add(match);
                for (String m :
                        matches) {
                    out.println(m + n);
            }

            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (PatternSyntaxException e)
        {
            e.getDescription();
        }
    }
}


