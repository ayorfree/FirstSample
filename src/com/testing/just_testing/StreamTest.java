package com.testing.just_testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ayorfree
 * @create 2017-10-20-上午8:30
 */

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("coil");
        list.add("death in juen");
        list.add("current93");
        list.add("psychic tv");

        Stream<String> words = list.stream();
        Stream<String> longwords = words.filter(w -> w.length() > 3);
        String[] results = longwords.toArray(String[] ::new);
        for (String s :
                results) {
            System.out.println(s);
        }
    }
}
