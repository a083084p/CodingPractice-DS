package org.example;

import java.util.Collections;

public class ReverseStringOfWords {

    public static String reverseWords(String s) {

        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();

        int start = 0;
        int end = str.length-1;
        String temp;

        while (start < end) {
            temp = str[end];
            str[end] = str[start];
            str[start] = temp;
            start++;
            end--;
        }

        for (String s1 : str){
            if (!s1.isEmpty()) {
                sb.append(s1).append(" ");
            }
        }

        return sb.toString().strip();
    }

    public static void main(String[] args) {
        String s = " the sky is  blue ";

        System.out.println(reverseWords(s));

    }


}
