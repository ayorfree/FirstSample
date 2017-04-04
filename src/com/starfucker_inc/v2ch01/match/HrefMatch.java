package com.starfucker_inc.v2ch01.match;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
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

            while (matcher.find()){
                int start = matcher.start();
                int end = matcher.end();
                String match = input.substring(start, end);
                System.out.println(match);
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
