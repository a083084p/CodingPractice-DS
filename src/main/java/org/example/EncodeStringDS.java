package org.example;

import java.util.HashMap;
import java.util.Map;

public class EncodeStringDS {

    public static void main(String[] args) {

        System.out.println("encode string: " + encodeString("daaaabbccca"));
//        System.out.println("encode string: " + encodeString("a"));
//        System.out.println("decode string: " + decodeString("4a2b3c1a"));
    }


    public static String encodeString(String str) {

        char[] arr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
//            map.merge(c, 1, Integer::sum);
            map.put(c, map.getOrDefault(c,0) + 1);
//            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getValue()).append(entry.getKey());
        }

        return sb.toString();
    }


}
