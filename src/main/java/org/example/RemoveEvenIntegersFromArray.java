package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveEvenIntegersFromArray {

    public static void main(String[] args) {

        int[] arr = {3,2,4,7,10,6,5};
        System.out.println(Arrays.toString(removeEvenIntegers(arr)));
    }


    public static int[] removeEvenIntegers(int[] arr) {

//        Arrays.stream(arr).filter(n->n%2 != 0).forEach(System.out::println);
//        List<Integer> myList = Arrays.stream(arr).filter(n->n%2 != 0).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> myList = Arrays.stream(arr).boxed().filter(n->n%2 !=0).collect(Collectors.toCollection(ArrayList::new));
        return myList.stream().mapToInt(Integer::intValue).toArray();
    }


}
