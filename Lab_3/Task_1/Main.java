package Lab_3.Task_1;

import java.util.List;
import java.util.Arrays;
import For_Sortings.Sorting;
import For_Sortings.CountingSort;

public class Main {
    public static void main (String[] args){
        List<Integer> arr = Arrays.asList(124, 1, 68, 57, 0, 93, 60, 24, 71, 125, 70, 87, 83, 105, 34, 30, 15, 1, 2);
        int N = arr.size();

        Sorting<Integer> sorting = new CountingSort();
        sorting.sort(arr);

        System.out.println(N);
        for(int i : arr) {
            System.out.print(i + " ");
        }

        
    }
}
