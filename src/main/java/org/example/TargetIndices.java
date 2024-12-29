package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetIndices {

    public static void main(String[] args) {
        int[] nums = {1,3,7,9,2};
        int target = 11;

        System.out.println(Arrays.toString(returnIndices(nums, target)));
    }



    public static int[] returnIndices(int[] nums, int target) {

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        int n_t_f = 0;

        for (int p1=0; p1<nums.length; p1++) {

            if (!map.containsKey(nums[p1])) {
                n_t_f = target - nums[p1];
                map.put(n_t_f, p1);
            } else {
                result[0] = map.get(n_t_f);
                result[1] = p1;
                return result;
            }

        }

        return null;
    }


//    public static int[] returnIndices(int[] nums, int target) {
//
//        int[] result = new int[2];
//
//        for (int p1=0; p1<nums.length; p1++) {
//            int n_t_f = target - nums[p1];
//            for (int p2=p1+1; p2<nums.length; p2++) {
//                if (nums[p2] == n_t_f) {
//                    result[0] = p1;
//                    result[1] = p2;
//                    return result;
//                }
//            }
//        }
//
//        return null;
//    }

}
