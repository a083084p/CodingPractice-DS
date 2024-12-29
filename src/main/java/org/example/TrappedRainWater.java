package org.example;

public class TrappedRainWater {

    public static void main(String[] args) {

        int[] nums = {0,1,0,2,1,0,3,1,0,1,2};
//        System.out.println(totalWater(nums));
        System.out.println(totalWaterOptimized(nums));
    }



    public static int totalWaterOptimized(int[] heights) {

        int totalWater = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int lP = 0;
        int rP = heights.length - 1;

        while (lP < rP) {

            if (heights[lP] <= heights[rP]) {
                if (heights[lP] >= maxLeft) {
                    maxLeft = heights[lP];
                } else {
                    totalWater += maxLeft - heights[lP];
                }
                lP++;
            } else {
                if (heights[rP] >= maxRight) {
                    maxRight = heights[rP];
                } else  {
                    totalWater += maxRight - heights[rP];
                }
                rP--;
            }

        }

        return totalWater;

    }


    public static int totalWater(int[] heights) {

        int totalWater = 0;

        for (int p=0; p<heights.length; p++) {

            int leftP = p;
            int rightP = p;
            int maxLeft = 0;
            int maxRight = 0;

            while (leftP >= 0) {
                maxLeft = Math.max(maxLeft, heights[leftP]);
                leftP--;
            }

            while (rightP < heights.length) {
                maxRight = Math.max(maxRight, heights[rightP]);
                rightP++;
            }

            int currentWater = Math.min(maxLeft, maxRight) - heights[p];

            if (currentWater >= 0) {
                totalWater = totalWater + currentWater;
            }

        }

        return totalWater;

    }


}
