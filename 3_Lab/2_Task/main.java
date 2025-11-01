import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    // public static void sort(List<BigInteger> arr) {
    //     int k = 1;
    //     for(int i = 0; i < 20; i++, k *= 10) {
    //         int count[] = new int[10];

    //         for(BigInteger num : arr) {
    //             BigInteger temp = num.divide(BigInteger.valueOf(k)).mod(BigInteger.valueOf(10));
    //             int digit = temp.intValue(); 
    //             count[digit]++;
    //         }    
    //         for(int j = 1; j < 10; j++) {
    //             count[j] += count[j - 1];
    //         }
            
    //         List<BigInteger> newArr = new ArrayList<>();
    //         for(int j = 0; j < arr.size(); j++) {
    //             newArr.add(null);
    //         }

    //         for(int j = arr.size() - 1 ; j >= 0; j--) {
    //             BigInteger num = arr.get(j);
    //             BigInteger temp = num.divide(BigInteger.valueOf(k)).mod(BigInteger.valueOf(10));
    //             int digit = temp.intValue(); 
    //             newArr.set(count[digit] - 1, num);
    //             count[digit]--;
    //         }
    //         for (int j = 0; j < arr.size(); j++) {
    //         arr.set(j, newArr.get(j));
    //         }   
    //     }
    // }
    
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
