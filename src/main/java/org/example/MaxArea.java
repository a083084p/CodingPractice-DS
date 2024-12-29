package org.example;

public class MaxArea {

    public static void main(String[] args) {
//        int[] nums = {7,1,2,3,9};
        int[] nums = {2,3,4,5,18,17,6};
        System.out.println(maximumArea(nums));
    }


    public static int maximumArea(int[] nums) {

    int maxArea = 0;
    int area;
    int a = 0;
    int b = nums.length-1;

    while (a<b) {
        area = Math.min(nums[a], nums[b]) * (b - a);
        maxArea = Math.max(maxArea, area);

        if (nums[a] < nums[b]) {
            a++;
        } else {
            b--;
        }
    }

//    for (int a=0; a<nums.length-1; a++) {
//            area = Math.min(nums[a], nums[nums.length-1]) * ((nums.length-1) - a);
//            maxArea = Math.max(maxArea, area);
//    }

    return maxArea;
    }




//    public static int maximumArea(int[] nums) {
//
//        int maxArea = 0;
//        int area;
//
//        for (int a=0; a<nums.length; a++) {
//            for (int b=a+1; b<nums.length; b++) {
//                area = Math.min(nums[a], nums[b]) * (b - a);
//                maxArea = Math.max(maxArea, area);
//            }
//        }
//
//        return maxArea;
//    }



}
