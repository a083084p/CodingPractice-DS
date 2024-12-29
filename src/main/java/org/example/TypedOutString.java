package org.example;

public class TypedOutString {

    public static void main(String[] args) {
        System.out.println(compareString("a###b", "b"));
    }





    public static boolean compareString(String s, String t) {
        return finalString(s).equals(finalString(t));
    }


    public static String finalString (String str) {
//        char[] cArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int charCounter = 0;


        for (int i=0; i<str.length(); i++) {
            if(str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                charCounter++;
            } else {
                if (!sb.toString().isEmpty()) {
                    sb.deleteCharAt(--charCounter);
                }
            }
        }

//        for (char c : cArray) {
//            if (c != '#') {
//                sb.append(c);
//                charCounter++;
//            } else {
//                if (!sb.toString().isEmpty()) {
//                    sb.deleteCharAt(--charCounter);
//                }
//            }
//        }

        return sb.toString();
    }

}
