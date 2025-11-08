package Lab_2.Task_1;

import For_Sortings.InsertionSort;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main (String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 5, 1, 1, 2, 6, 8, 9, 3);

        InsertionSort sorting = new InsertionSort();
        sorting.sort(arr);

        for(int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
    }
}