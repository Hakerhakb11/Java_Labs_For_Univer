package Lab_7.Task_2;

import java.util.List;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String routeToDir = "Lab_7/Task_2/";

        // List<Integer> arr = Arrays.asList(7, 1, 4, 3, 3, 5, 4, 8, 6, 9);
        // List<Integer> arr = Arrays.asList(10, 9, 2, 5, 3, 7, 101, 18);

        List<String> stringOut = Files.readAllLines(Paths.get(routeToDir + "lis-input.txt"));
        
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
            int exitCode = 1;
            while (exitCode == 1) {
                exitCode = 0;
                int o = 0;
                int checkNum = i;

                tempArr.add(arr.get(checkNum));
                for (int j = checkNum; j < arr.size(); j++) {
                    if (arr.get(checkNum) < arr.get(j) && k - o++ < 1) {
                        tempArr.add(arr.get(j));
                        exitCode = 1;
                        checkNum = j;
                    }
                }
                k++;

                if (bestArr.size() < tempArr.size()) {
                    bestArr.clear();
                    bestArr.addAll(tempArr);
                }
                tempArr.clear();
            }
        }
        
        System.err.println(bestArr.size());
        for (int i : bestArr) {
            System.out.print(i + " ");
        }

        String outPut = bestArr.size() + "\n" + bestArr;
        Files.write(Paths.get(routeToDir + "lis-output.txt"), outPut.getBytes());
    }
}
