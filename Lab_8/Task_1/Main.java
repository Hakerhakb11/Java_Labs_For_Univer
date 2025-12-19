package Lab_8.Task_1;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -6, 2, 6, -8, 2, 3, 5};
        int x = 4;
        int y = 4;
        
        PrefixSum func = new PrefixSum();
        int[] prefix = func.prefixSum(arr, x, y);
        int sum = prefix[y] - prefix[x - 1];
        
        // solution without prefix_sum algorithm
        int sum2 = 0;
        List<Integer> arr2 = Arrays.asList(1, 4, 3, -6, 2, 6, -8, 2, 3, 5);
        for (int i = x; i <= y; i++) {
            sum2 += arr2.get(i);
        }
        System.err.println("\nResult: " + sum);
        System.out.println("Must be: " + sum2);
    }
}
