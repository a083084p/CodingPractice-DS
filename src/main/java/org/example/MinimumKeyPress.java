package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinimumKeyPress {

    public static void main(String[] args) {
        System.out.println(minimumKeypresses("apple"));
    }


    public static int minimumKeypresses(String s) {
        // Frequency map
        Map<Character, Long> freqMap = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        // Sort characters by frequency in descending order
        List<Map.Entry<Character, Long>> sortedEntries = freqMap.entrySet()
                .stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                .toList();

        // Map characters to keypress counts
        Map<Character, Integer> keypressMap = new HashMap<>();
        int[] keypressCounts = {1, 1, 1}; // Initial keypress counts for each position on a button
        int button = 1; // Button index (1 to 9)

        for (Map.Entry<Character, Long> entry : sortedEntries) {
            char character = entry.getKey();
            int keypress = keypressCounts[button % 3]; // Get the keypress count based on the current button
            keypressMap.put(character, keypress);
            keypressCounts[button % 3]++; // Increment the keypress count for the next character on the same button
            button++;
        }

        // Calculate total keypresses

        return s.chars()
                .mapToObj(c -> (char) c)
                .mapToInt(keypressMap::get)
                .sum();
    }

}
