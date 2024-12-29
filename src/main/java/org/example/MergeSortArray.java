package org.example;

public class MergeSortArray {


    public static void main(String[] args) {
        int[] arr = {2,65,34,2,1,7,8,3,4,5,6,9,245,543};
//        int[] arr = {6, 3, 9, 5, 2, 8};
        divide(arr, 0, arr.length-1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


    public static void divide(int[] arr, int si, int ei) {
        int mid = si + (ei - si) / 2;
        if (si >= ei) {
            return;
        }

        divide(arr, si, mid);
        divide(arr, mid+1, ei);
        conquer(arr, si, mid, ei);
    }

    public static void conquer(int[] arr, int si, int mid, int ei) {

        int indx1 = si;
        int indx2 = mid+1;
        int x = 0;
        int[] merged = new int[ei - si + 1];

        while (indx1 <= mid && indx2 <= ei) {
            if (arr[indx1] <= arr[indx2]) {
                merged[x++] = arr[indx1++];
            } else {
                merged[x++] = arr[indx2++];
            }
        }

        while (indx1 <= mid) {
            merged[x++] = arr[indx1++];
        }

        while (indx2 <= ei) {
            merged[x++] = arr[indx2++];
        }

        int i=si;
        for (int a : merged) {
            arr[i] = a;
            i++;
        }

    }

}
