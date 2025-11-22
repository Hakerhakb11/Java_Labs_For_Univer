package Lab_6.Task_1;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,5,12, 100);
        List<Integer> req = Arrays.asList(1, 2, 3, 4, 2, 7, 11, 15,35,45,88);
        
        BinarySearch searchPlace = new BinarySearch();
        List<Integer> out = searchPlace.searchNearValue(arr, req);
        
        for (int i : out) {
            System.out.println(i);
        }
    }
}
