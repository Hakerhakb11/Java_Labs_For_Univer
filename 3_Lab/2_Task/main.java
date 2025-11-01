// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

public class main {
    public static void sort(List<BigInteger> arr) {
        // String str = obj.toString();
        // char digitChar = str.charAt(2);
        // int digit = Character.getNumericValue(digitChar);
        // System.out.println(digit);
        // System.out.println(obj.intValue() / 10 % 10);
        // System.out.println(obj);
        int k = 1;
        for(int i = 0; i < 3; i++, k *= 10) {
            int count[] = new int[10];
            for(BigInteger num : arr) {
                
                System.out.print(num + " ");
                int digit = num.intValue() / k % 10;
                System.out.println(digit);


                count[digit]++;
            }
            for(int j : count) {
                System.out.print(", " + j);
            }
            System.out.println(" ");
        }
    }
    
    public static void main(String[] args) {
        BigInteger num1 = new BigInteger("157");
        BigInteger num2 = new BigInteger("116");
        BigInteger num3 = new BigInteger("129");
        BigInteger num4 = new BigInteger("133");

        List<BigInteger> nums = Arrays.asList(num1, num2, num3, num4);
        
        System.out.println("\nBefore\n" + nums);

        sort(nums);

        System.out.println("\nAfter\n" + nums);


    }

}
