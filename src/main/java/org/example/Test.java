package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        ArrayList<String> colors = new ArrayList<>();

        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        colors.add("blue");
        colors.add("red");
        colors.add("orange");
        colors.add("red");
        colors.add("blue");

        findDuplicateColors(colors);
    }



    public static void findDuplicateColors(ArrayList<String> list) {

        Map<String, Integer> cMap = new HashMap<>();

        for (String c : list) {
            cMap.merge(c, 1, Integer::sum);
        }

        for (Map.Entry<String, Integer> entry : cMap.entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
    }
}


