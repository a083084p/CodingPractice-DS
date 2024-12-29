package org.example;

import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {2,65,34,2,1,7,8,3,4,5,6,9,245,543};
//        System.out.println(Arrays.toString(bubbleSort1(arr)));
//        System.out.println(Arrays.toString(selectionSort(arr)));

        System.out.println(Arrays.toString(insertionSort(arr)));
    }


    public static int[] insertionSort (int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int j = i-1;

            while (j >= 0 && current < nums[j]) {
                nums[j+1] = nums[j];
                j--;
            }

            nums[j+1] = current;

        }

        return nums;

    }



    public static int[] selectionSort (int[] nums) {

        int temp;

        for (int i=0; i<nums.length; i++) {
            int minIndex = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }


//    public static int[] selectionSort (int[] nums) {
//
//        for (int i=0; i<nums.length; i++) {
//            int smallest = nums[i];
//            for (int j=i; j<nums.length; j++) {
//                if (smallest > nums[j]) {
//                    smallest = nums[j];
//                    nums[j] = nums[i];
//                    nums[i] = smallest;
//                }
//            }
//        }
//
//        return nums;
//
//    }




    public static int[] bubbleSort1 (int[] nums) {

        int temp = 0;
        int i=0;
        int j = 0;
        int sum;

        for(i=0; i<nums.length; i++) {
            for (j=0; j<nums.length-1; j++) {
                if (nums[j] > nums[j+1]) {
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        sum = i+j;

        System.out.println(sum);
        return nums;

    }


    public static int[] bubbleSort2 (int[] nums) {
        int temp=0;
        int i;
        int j = 0;
        int sum;
        
        for (i=0; i<nums.length; i++) {
            for (j=i+1; j<nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        sum = i+j;
        System.out.println(sum);
        return nums;
    }


}
