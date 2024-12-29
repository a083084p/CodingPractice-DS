package org.example;

public class MinimumSizeSubarraySum {

    public static void main(String[] args) {

        int[] nums = {2,3,1,2,4,3};

        System.out.println(minSubArrayLen(7, nums));

    }


//    nums = [2,3,1,2,4,3]

    public static int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;

        for (int right = 0; right < n; right++) {
            sum = sum + nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum = sum - nums[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }


}
