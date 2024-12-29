package org.example;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

//        System.out.println(isPalindrome("abanahatar"));

    }


    public static boolean isPalindrome(String s) {

        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        System.out.println("value of s: " + s);

        int start = 0;
        int end = s.length() -1 ;

        if (s.length() == 2) {
            return true;
        }

        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;

    }

    public static boolean isPalindrome2(String s) {

        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        if (s.length() % 2 == 0) {
            return s.substring(0, s.length()/2).contentEquals(new StringBuilder(s.substring(s.length()/2)).reverse());
        } else {
            return s.substring(0, s.length()/2).contentEquals(new StringBuilder(s.substring(s.length()/2+1)).reverse());
        }

    }

}
