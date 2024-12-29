package org.example;

public class EncodeString {

    public static void main(String[] args) {

        System.out.println("encode string: " + encodeString("daaaabbccca"));
//        System.out.println("encode string: " + encodeString("a"));
        System.out.println("decode string: " + decodeString("4a2b3c1a"));
    }



//    aaaabbccc
//    4a2b3c
    public static String encodeString(String str) {

        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int counter = 0;
        char preChar = charArray[0];

        for (char c : charArray) {
            if (c == preChar) {
                counter++;
            } else {
                sb.append(counter).append(preChar);
                counter = 1;
                preChar = c;
            }
        }

//        sb.append(counter).append(preChar);

        return sb.toString();

    }

    public static String decodeString(String str) {

        if (str == null || str.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i=0; i<str.length(); i=i+2) {
            char character = str.charAt(i);
            int counter = character - '0';

            for (int j=0; j<counter; j++) {
                String str1 = String.valueOf(str.charAt(i + 1));
                sb.append(str1);
            }


//            sb.append(String.valueOf(str.charAt(i+1)).repeat(Math.max(0, counter)));
        }

        return sb.toString();
    }

}
