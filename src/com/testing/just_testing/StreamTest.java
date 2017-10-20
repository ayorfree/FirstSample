package com.testing.just_testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
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
        Stream<Character> longwords = words.filter(w -> w.length() > 3).map(s -> s.charAt(0));
        longwords.forEach(System.out::println);

        Stream<Double> echo = Stream.generate(Math::random).limit(20).map(x -> x*3);
        echo.forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String s) {
        List<Character> list = new ArrayList<>();

        for (char c :
                s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
