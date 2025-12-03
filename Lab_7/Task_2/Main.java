package Lab_7.Task_2;

// import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start lab_7.2\n");

        // List<Integer> arr = Arrays.asList(7, 1, 4, 3, 3, 5, 4, 8, 6, 9);
        // List<Integer> arr = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18);

        List<String> stringOut = Files.readAllLines(Paths.get("Lab_7/Task_2/lis-input.txt"));
        
        String[] splitedOut = stringOut.get(1).split(" ");
        
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < splitedOut.length; i++) {
            arr.add(Integer.parseInt(splitedOut[i]));
        }
        for (int i : arr) {
            System.err.print(i + " ");
        }System.err.println("\n");

        List<Integer> bestArr = new ArrayList<>();
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

                if (bestArr.size() < tempArr.size()) {
                    bestArr.clear();
                    bestArr.addAll(tempArr);
                }
                System.err.println("\nBESTARRRR111\n");
                for (int z : bestArr) {
                    System.out.print(z + " ");
                }

                // for (int j : tempArr) {
                //     System.err.print(j + " ");
                // }System.err.println();
                System.err.println("\nend of cycle\n");
                tempArr.clear();
                System.err.println("\nBESTARRRR2222\n");
                for (int z : bestArr) {
                    System.out.print(z + " ");
                }
            }
            System.err.println("\nEND OF BIG cycle------------------------\n");
        }
        
        System.err.println(bestArr.size());

        for (int i : bestArr) {
            System.out.print(i + " ");
        }
        

        System.out.println("\n\nEnd lab_7.2");
    }
}
