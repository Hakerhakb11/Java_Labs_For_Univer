package Lab_2.Task_1;

import java.util.List;
import java.util.Arrays;
import For_Sortings.Sorting;
import For_Sortings.InsertionSort;

public class Main {
    public static void main (String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 5, 1, 1, 2, 6, 8, 9, 3);

        Sorting<Integer> sorting = new InsertionSort();
        sorting.sort(arr);

        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}