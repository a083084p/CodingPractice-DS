package org.example;

import java.util.*;

public class LongestValidSubstring {


    public static void main(String[] args) {

        List<String> forbidden = new ArrayList<>();

        forbidden.add("aaac");
        forbidden.add("aac");
        forbidden.add("aaa");
        forbidden.add("aaac");
        System.out.println("longestValidSubstring: " + longestValidSubstring("aaac", forbidden));
    }


//    word = "leetcode", forbidden = ["de","le","e"]


    public static int longestValidSubstring(String word, List<String> forbidden) {
        // Early exit for the specific edge case
        if (word.length() == 1 && forbidden.size() == 1 && word.contains(forbidden.get(0))) {
            return 0;
        }

        Set<String> forbiddenSet = new HashSet<>(forbidden);
        int maxLength = 0;
        int length = word.length();

        // Outer loop to set the start of the substring
        for (int start = 0; start < length; start++) {
            // Inner loop to extend the substring from start
            for (int end = start + 1; end <= length; end++) {
                String subString = word.substring(start, end);

                if (isValid(subString, forbiddenSet)) {
                    maxLength = Math.max(maxLength, subString.length());
                } else {
                    break; // Break the loop if substring is invalid
                }
            }
        }

        return maxLength;
    }

    private static boolean isValid(String subString, Set<String> forbiddenSet) {
        for (String str : forbiddenSet) {
            if (subString.contains(str)) {
                return false;
            }
        }
        return true;
    }




//    public static int longestValidSubstring(String word, List<String> forbidden) {
//
//        if (word.length() == 1 && forbidden.size() == 1 && word.contains(forbidden.get(0))) {
//            return 0;
//        }
//
//        Map<String, Integer> map = new HashMap<>();
//
//        int length = word.length();
//
//        for (int start=0; start < length; start++) {
//
//            for (int end = start + 1; end <= length; end++) {
//                String subString = word.substring(start, end);
//                boolean valid = true;
//
//                for (String str : forbidden) {
//
//                    if (subString.contains(str)) {
//                        valid = false;
//                        break;
//                    }
//
//                }
//
//                if (valid) {
//                    map.put(subString, subString.length());
//                }
//
//
//            }
//        }
//
//        return Collections.max(map.values());
//
//    }


}
