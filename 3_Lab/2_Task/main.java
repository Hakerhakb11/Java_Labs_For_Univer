import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    
    public static void main(String[] args) {
        // BigInteger num1 = new BigInteger("151");
        // BigInteger num2 = new BigInteger("111");
        // BigInteger num3 = new BigInteger("371");
        // BigInteger num4 = new BigInteger("431");
        // List<BigInteger> arr = Arrays.asList(num1, num2, num3, num4);

        // List<BigInteger> arr = Arrays.asList(BigInteger.valueOf(157),
        // BigInteger.valueOf(101), BigInteger.valueOf(201),
        // BigInteger.valueOf(301), BigInteger.valueOf(112),
        // BigInteger.valueOf(212), BigInteger.valueOf(123),
        // BigInteger.valueOf(134), BigInteger.valueOf(145),
        // BigInteger.valueOf(101), BigInteger.valueOf(201));

        BigInteger num1 = new BigInteger("19446744073709551657");
        BigInteger num2 = new BigInteger("18446744073709551616");
        BigInteger num3 = new BigInteger("18446744073709551629");
        BigInteger num4 = new BigInteger("18446744073709551633");
        List<BigInteger> arr = Arrays.asList(num1, num2, num3, num4);

        System.out.println("\nBefore\n" + arr);

        Sorting sorting = new RadixSort();

         sorting.sort(arr);

        System.out.println("\nAfter\n" + arr);
    }
}
