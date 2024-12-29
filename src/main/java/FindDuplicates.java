import java.util.*;
import java.util.stream.Collectors;

public class FindDuplicates {

    public static void main(String[] args) {

        Integer[] arr = {10,2,3,4,4,4,56,7,88,9,10,10,11,1,2,3,4,1,2,3,3,2,1};

        ArrayList<Integer> list = new ArrayList<>();

        Collections.addAll(list, arr);
        printDuplicates(list);
    }


    public static void printDuplicates(ArrayList<Integer> myList) {

//        myList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i : myList) {
            myMap.merge(i, 1, Integer::sum);
        }

        myMap.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println(" The " + entry.getKey() + " has " + entry.getValue() + " entries"));

//        for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
//            if (entry.getValue() > 1) {
//                System.out.println(" The " + entry.getKey() + " has " + entry.getValue() + " entries");
//            }
//        }

    }

}
