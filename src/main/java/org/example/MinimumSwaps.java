package org.example;

public class MinimumSwaps {

    public static void main(String[] args) {
        int[] nums = {3,4,5,5,3,1};
        System.out.println(minimumSwaps(nums));

    }

//    Input: nums = [3,4,5,5,3,1]

    public static int minimumSwaps(int[] nums) {

        int min_index = 0;
        int max_index = 0;
        int min_swaps = 0;

        if (nums.length <= 1) {
            return min_swaps;
        }


        for (int i=1; i<nums.length; i++) {
            if (nums[min_index] > nums[i]) {
                min_index = i;
            }
            if (nums[max_index] <= nums[i]) {
                max_index = i;
            }
        }

        min_swaps = min_index + nums.length - 1 - max_index;

        if (min_index > max_index) {
            min_swaps = min_swaps - 1;
        }

        return min_swaps;

    }


}
