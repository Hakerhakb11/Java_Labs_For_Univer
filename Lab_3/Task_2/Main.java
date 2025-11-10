package Lab_3.Task_2;

import java.util.List;
import java.util.Arrays;
import java.math.BigInteger;
import For_Sortings.Sorting;
import For_Sortings.RadixSort;

public class Main {

    public static void main(String[] args) {
        
        BigInteger num1 = new BigInteger("19446744073709551657");
        BigInteger num2 = new BigInteger("18446744073709551616");
        BigInteger num3 = new BigInteger("18446744073709551629");
        BigInteger num4 = new BigInteger("18446744073709551633");
        List<BigInteger> arr = Arrays.asList(num1, num2, num3, num4);

        System.out.println("\nBefore\n" + arr);

        Sorting<BigInteger> sorting = new RadixSort();
        sorting.sort(arr);

        System.out.println("\nAfter\n" + arr);
    }
}
