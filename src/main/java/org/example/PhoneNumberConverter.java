package org.example;

import java.util.HashMap;

public class PhoneNumberConverter {

    // Map for character to digit conversion based on phone keypad
    private static final HashMap<Character, Integer> letterToDigitMap = new HashMap<>();

    static {
        letterToDigitMap.put('A', 2);
        letterToDigitMap.put('B', 2);
        letterToDigitMap.put('C', 2);
        letterToDigitMap.put('D', 3);
        letterToDigitMap.put('E', 3);
        letterToDigitMap.put('F', 3);
        letterToDigitMap.put('G', 4);
        letterToDigitMap.put('H', 4);
        letterToDigitMap.put('I', 4);
        letterToDigitMap.put('J', 5);
        letterToDigitMap.put('K', 5);
        letterToDigitMap.put('L', 5);
        letterToDigitMap.put('M', 6);
        letterToDigitMap.put('N', 6);
        letterToDigitMap.put('O', 6);
        letterToDigitMap.put('P', 7);
        letterToDigitMap.put('Q', 7);
        letterToDigitMap.put('R', 7);
        letterToDigitMap.put('S', 7);
        letterToDigitMap.put('T', 8);
        letterToDigitMap.put('U', 8);
        letterToDigitMap.put('V', 8);
        letterToDigitMap.put('W', 9);
        letterToDigitMap.put('X', 9);
        letterToDigitMap.put('Y', 9);
        letterToDigitMap.put('Z', 9);
    }

    // Method to convert last four letters to digits
    public static String convertLastFourLetters(String phoneNumber) {
        // Extract last four characters
        String lastFour = phoneNumber.substring(phoneNumber.length() - 4).toUpperCase();
        StringBuilder converted = new StringBuilder();

        // Convert each character to its corresponding digit
        for (char c : lastFour.toCharArray()) {
            if (letterToDigitMap.containsKey(c)) {
                converted.append(letterToDigitMap.get(c));
            } else {
                converted.append(c); // Handle digits or invalid characters
            }
        }

        return converted.toString();
    }

    public static void main(String[] args) {
        String phoneNumber = "1-800-8888-HELP";

        // Convert the last four alphabetic characters and display the result
        String convertedLastFour = convertLastFourLetters(phoneNumber);
        System.out.println("Original Phone Number: " + phoneNumber);
        System.out.println("Converted Phone Number: 1-800-8888-" + convertedLastFour);
    }
}

