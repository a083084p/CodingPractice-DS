package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortArrayList {

    public static void main(String[] args) {

        int[] arr = {2,65,34,2,1,7,8,3,4,5,6,9,245,543};
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int a : arr) {
            arrayList.add(a);
        }

        divide(arrayList, 0, arrayList.size() - 1);

        arrayList.forEach(System.out::println);

    }


    public static void divide (ArrayList<Integer> arrayList, int si, int ei) {

        if (si >= ei) {
            return;
        }

        int mid = si + (ei - si) / 2;

        divide(arrayList, si, mid);
        divide(arrayList, mid + 1, ei);
        conquer(arrayList, si, mid, ei);

    }

    public static void conquer(ArrayList<Integer> arrayList, int si, int mid, int ei) {

        ArrayList<Integer> merged = new ArrayList<>();
        int indx1 = si;
        int indx2 = mid + 1;
        int x=0;

        while(indx1 <= mid && indx2 <= ei) {
            if (arrayList.get(indx1) <= arrayList.get(indx2)) {
                merged.add(arrayList.get(indx1++));
            } else {
                merged.add(arrayList.get(indx2++));
            }
        }

        while (indx1 <= mid) {
            merged.add(arrayList.get(indx1++));
        }

        while (indx2 <= ei) {
            merged.add(arrayList.get(indx2++));
        }

        int i=si;
        for (int a : merged) {
            arrayList.set(i, a);
            i++;
        }

    }






}
