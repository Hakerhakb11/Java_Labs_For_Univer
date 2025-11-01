import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> arr) {
        int k = 1;
        for(int i = 0; i < 20; i++, k *= 10) {
            int count[] = new int[10];
        
            for(BigInteger num : arr) {
                BigInteger temp = num.divide(BigInteger.valueOf(k)).mod(BigInteger.valueOf(10));
                int digit = temp.intValue(); 
                count[digit]++;
            }    
            for(int j = 1; j < 10; j++) {
                count[j] += count[j - 1];
            }
            
            List<BigInteger> newArr = new ArrayList<>();
            for(int j = 0; j < arr.size(); j++) {
                newArr.add(null);
            }
            
            for(int j = arr.size() - 1 ; j >= 0; j--) {
                BigInteger num = arr.get(j);
                BigInteger temp = num.divide(BigInteger.valueOf(k)).mod(BigInteger.valueOf(10));
                int digit = temp.intValue(); 
                newArr.set(count[digit] - 1, num);
                count[digit]--;
            }
            for (int j = 0; j < arr.size(); j++) {
                arr.set(j, newArr.get(j));
            }   
        }
    }
}