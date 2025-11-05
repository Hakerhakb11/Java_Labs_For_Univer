package For_Sortings;

public class Main {
    public static void main (String[] args){
        // 1 СПОСОБ ЗАПУСКА ----------------------
        // import java.math.BigInteger;
        // BigInteger num1 = new BigInteger("19446744073709551657");
        // BigInteger num2 = new BigInteger("18446744073709551616");
        // BigInteger num3 = new BigInteger("18446744073709551629");
        // BigInteger num4 = new BigInteger("18446744073709551633");
        // List<BigInteger> arr = Arrays.asList(num1, num2, num3, num4);
        // Sorting sorting = new RadixSort();
        // int N = arr.size();
        
        // 2 СПОСОБ ЗАПУСКА ----------------------
        // import java.util.List;
        // import java.util.Arrays;
        // List<Integer> arr = Arrays.asList(124, 1, 68, 57, 0, 93, 60, 24, 71, 125, 70, 87, 83, 105, 34, 30, 15, 1, 2);
        // int N = arr.size();
        // Sorting sorting = new CountingSort();
        
        // 3 СПОСОБ ЗАПУСКА ----------------------
        int[] arr = {1, 2, 5, 1, 1, 2, 6, 8, 9, 3};
        int N = arr.length;
        // Sorting2 sorting = new InsertionSort();
        Sorting2 sorting = new MergeSort();


        sorting.sort(arr);

        System.out.println("\n\rAfter\n" + N);
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }
}