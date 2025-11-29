package Lab_7.Task_2;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start lab_7.2\n");

        List<Integer> arr = Arrays.asList(7, 1, 4, 3, 3, 5, 4, 8, 6, 9);
        for (int i : arr) {
            System.err.print(i + " ");
        }System.err.println("\n");

        List<Integer> bestArr = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        List<Integer> tempArr = new ArrayList<>();

        
        for (int i = 0; i < arr.size(); i++) {
            int k = 0;
            int count = 1;
            while (count > 0) {
                int o = 0;
                int checkNum = i;
                count = 0;

                tempArr.add(arr.get(checkNum));
                for (int j = checkNum; j < arr.size(); j++) {
                    if (arr.get(checkNum) < arr.get(j) && k - o++ < 1) {
                        tempArr.add(arr.get(j));
                        count++;
                        checkNum = j;
                    }
                } 
                k++;
                
                // 7 1 4 3 3 5 4 8 6 9
                for (int j : tempArr) {
                    System.err.print(j + " ");
                }System.err.println();
                System.err.println("\nend of cycle\n");
                tempArr.clear();
            }
            System.err.println("\nEND OF BIG cycle------------------------\n");
        }
        
        

        System.out.println("\n\nEnd lab_7.2");
    }
}
