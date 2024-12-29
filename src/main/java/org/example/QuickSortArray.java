package org.example;

public class QuickSortArray {

    public static void main(String[] args) {
        int[] arr = {2,65,34,2,1,7,8,3,4,5,6,9,245,543};

        quickSort(arr, 0, arr.length - 1);

        for (int a : arr) {
            System.out.print(a + " ");
        }
    }


    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot_indx = partition(arr, low, high);

            quickSort(arr, low, pivot_indx-1);
            quickSort(arr, pivot_indx+1, high);

        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i; //pivot index

    }


}
