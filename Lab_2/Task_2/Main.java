package Lab_2.Task_2;

import For_Sortings.MergeSort;

public class Main {
    public static void main (String[] args) {
        int[] arr = {9, 2, 7, 6, 5, 4, 3, 7, 8, 9, 0, 1};
        int n = arr.length;

        MergeSort sorting = new MergeSort();
        sorting.sort(arr);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}