package For_Sortings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {
    private final int BASE = 10;
    
    @Override
    public void sort(List<BigInteger> arr) {
        int k = 1;
        for(int i = 0; i < 20; i++, k *= BASE) {
            int count[] = new int[BASE];
        
            for(BigInteger num : arr) {
                BigInteger temp = num.divide(BigInteger.valueOf(k)).mod(BigInteger.valueOf(BASE));
                int digit = temp.intValue(); 
                count[digit]++;
            }    
            for(int j = 1; j < BASE; j++) {
                count[j] += count[j - 1];
            }
            
            List<BigInteger> newArr = new ArrayList<>();
            for(int j = 0; j < arr.size(); j++) {
                newArr.add(null);
            }
            
            for(int j = arr.size() - 1 ; j >= 0; j--) {
                BigInteger num = arr.get(j);
                BigInteger temp = num.divide(BigInteger.valueOf(k)).mod(BigInteger.valueOf(BASE));
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