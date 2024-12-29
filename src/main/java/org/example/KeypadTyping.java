package org.example;

import java.util.*;

public class KeypadTyping {

    public static int minKeypresses(String s) {
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
//            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            frequencyMap.merge(c, 1, Integer::sum);
        }

        // Step 2: Sort the characters by frequency in descending order
        List<Map.Entry<Character, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
        sortedEntries.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // Step 3: Map characters to keypad buttons
        int[] keyPresses = {1, 1, 1, 2, 2, 2, 3, 3, 3}; // Keypress counts for positions in each button
        int totalKeyPresses = 0;
        int index = 0;

        for (Map.Entry<Character, Integer> entry : sortedEntries) {
//            char c = entry.getKey();
            int freq = entry.getValue();
            int buttonIndex = index / 3;
            totalKeyPresses += keyPresses[buttonIndex] * freq;
            index++;
        }

        return totalKeyPresses;
    }

    public static void main(String[] args) {
        String s1 = "apple";
        System.out.println("Minimum keypresses for 'apple': " + minKeypresses(s1)); // Output: 5

        String s2 = "abcdefghijkl";
        System.out.println("Minimum keypresses for 'abcdefghijkl': " + minKeypresses(s2)); // Output: 15

        String s3 = "leetcode";
        System.out.println("Minimum keypresses for 'leetcode': " + minKeypresses(s3)); // Output: 10
    }
}

