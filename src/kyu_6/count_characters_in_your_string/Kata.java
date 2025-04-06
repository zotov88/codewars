package kyu_6.count_characters_in_your_string;

import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static void main(String[] args) {
        System.out.println(count("Hello world"));
    }

    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> countOfCharsMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (!countOfCharsMap.containsKey(key)) {
                countOfCharsMap.put(key, 1);
            } else {
                countOfCharsMap.put(key, countOfCharsMap.get(key) + 1);
            }
        }
        return countOfCharsMap;
    }
}