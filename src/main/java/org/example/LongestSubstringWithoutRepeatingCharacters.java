package org.example;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abccabb"));
    }


//    Input: s = "abcabcbb"

    public static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int start = 0;
        int end = 0;

        while (end < s.length()) {
            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end++;
                maxLength = Math.max(maxLength, set.size());
            } else {
                set.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }





//    public static int lengthOfLongestSubstring(String s) {
//
//        if (s.length() == 1) {
//            return 1;
//        }
//
//        if (s.isEmpty()) {
//            return 0;
//        }
//
//        char[] charArray = s.toCharArray();
//        List<Character> characterList = new ArrayList<>();
//        List<Integer> integerList = new ArrayList<>();
//        int start = 0;
//        int end = charArray.length - 1;
//
//        while (start <= end) {
//            if (!characterList.contains(charArray[start])) {
//                characterList.add(charArray[start]);
//                start++;
//            } else {
//                integerList.add(characterList.size());
//                characterList.clear();
//            }
//        }
//
//        return Collections.max(integerList);
//
//    }



}
