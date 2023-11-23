package kyu_6.count_the_number_of_duplicates;

import java.util.HashMap;
import java.util.Map;

public class Kata {

    public static void main(String[] args) {

    }

    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        Map<Character, Integer> duplicateMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char key = text.charAt(i);
            if (!duplicateMap.containsKey(key)) {
                duplicateMap.put(key, 1);
            } else if (duplicateMap.get(key) == 1) {
                duplicateMap.put(key, 2);
            }
        }

        return (int) duplicateMap
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 2)
                .count();
    }
}
