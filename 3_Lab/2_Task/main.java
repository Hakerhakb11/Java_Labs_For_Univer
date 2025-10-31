// import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.math.BigInteger;

public class main {
    public static void sort(List<BigInteger> nums) {
        for(BigInteger obj : nums) {
            String str = obj.toString();
            if (str.length() >= 3) {
                char digitChar = str.charAt(2);
                int digit = Character.getNumericValue(digitChar);
                System.out.println(digit);
            }
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
// BigInteger num1 = new BigInteger("19446744073709551657");
// BigInteger num2 = new BigInteger("18446744073709551616");
// BigInteger num3 = new BigInteger("18446744073709551629");
// BigInteger num4 = new BigInteger("18446744073709551633");