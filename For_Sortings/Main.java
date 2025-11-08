package For_Sortings;

import java.util.List;
import java.util.Arrays;
// import java.math.BigInteger;

public class Main {
    public static void main (String[] args){
        // 1 СПОСОБ ЗАПУСКА ----------------------
        // BigInteger num1 = new BigInteger("19446744073709551657");
        // BigInteger num2 = new BigInteger("18446744073709551616");
        // BigInteger num3 = new BigInteger("18446744073709551629");
        // BigInteger num4 = new BigInteger("18446744073709551633");
        // List<BigInteger> arr = Arrays.asList(num1, num2, num3, num4);
        // Sorting sorting = new RadixSort();
        // int N = arr.size();
        
        // 2 СПОСОБ ЗАПУСКА ----------------------
        List<Integer> arr = Arrays.asList(124, 1, 68, 57, 0, 93, 60, 24, 71, 125, 70, 87, 83, 105, 34, 30, 15, 1, 2);
        int N = arr.size();
        // Sorting sorting = new InsertionSort();
        // Sorting sorting = new CountingSort();
        Sorting<Integer> sorting = new MergeSort();
        
        sorting.sort(arr);

        System.out.println("\n\rAfter\n" + N);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}