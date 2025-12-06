package Lab_8.Task_1;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -6, 2, 6, -8, 2, 3, 5};
        int x = 4;
        int y = 4;
        int sum = 0;
        int sum2 = 0;
        
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] += prefix[i - 1] + arr[i];
        }
        sum = prefix[y] - prefix[x - 1];
        
        // solution without prefix_sum algorithm
        List<Integer> arr2 = Arrays.asList(1, 4, 3, -6, 2, 6, -8, 2, 3, 5);
        for (int i = x; i <= y; i++) {
            sum2 += arr2.get(i);
        }
        
        System.err.println("\nResult: " + sum);
        System.out.println("Must be: " + sum2);
    }
}
