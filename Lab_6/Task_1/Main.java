package Lab_6.Task_1;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,5,12, 100);
        List<Integer> req = Arrays.asList(7, 11, 15,35,45,88, 8, 9);
        
        BinarySearch searchPlace = new BinarySearch();
        List<Integer> out = searchPlace.searchNearValue(arr, req);
        
        // orig massiv
        for (int i : arr) {
            System.out.print(i + " ");
        } System.out.println("\n");

        // req massiv
        for (int i : req) {
            System.out.print(i + " ");
        } System.out.println();

        // output massiv of numbers, which good to put number from orig
        for (int i : out) {
            System.out.print(i + " ");
        }
    }
}
