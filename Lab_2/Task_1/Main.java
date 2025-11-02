package Lab_2.Task_1;

import For_Sortings.InsertionSort;

public class Main {
    public static void main (String[] args) {
        int[] arr = {1, 2, 5, 1, 1, 2, 6, 8, 9, 3};
        int n = arr.length;

        InsertionSort sorting = new InsertionSort();
        sorting.sort(arr);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}