package Lab_7.Task_2;

import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_7.2\n");

        List<Integer> arr = Arrays.asList(7, 1, 4, 3, 3, 5, 4, 8, 6, 9);
        for (int i : arr) {
            System.err.print(i + " ");
        }System.err.println();

        List<Integer> bestArr = Arrays.asList(null, null, null, null, null, null, null, null, null, null);
        List<Integer> tempArr = Arrays.asList(null, null, null, null, null, null, null, null, null, null);

        // List<Integer> bestArr = new ArrayList<>(10);


        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i + 1)) {
                tempArr.set(i, arr.get(i));
                tempArr.set(i + 1, arr.get(i + 1));
            }
            for (int j : tempArr) {
            System.err.print(j + " ");
            }System.err.println();
        }
        
        

        System.out.println("\n\nEnd lab_7.2");
    }
}
