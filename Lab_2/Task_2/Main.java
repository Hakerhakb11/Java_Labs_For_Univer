package Lab_2.Task_2;

import For_Sortings.MergeSort;
import For_Sortings.Sorting;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args) {
        List<Integer> arr = Arrays.asList(9, 2, 7, 6, 5, 4, 3, 7, 8, 9, 0, 1);

        Sorting<Integer> sorting = new MergeSort();
        sorting.sort(arr);

        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}