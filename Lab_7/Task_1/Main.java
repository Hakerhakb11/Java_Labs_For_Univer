package Lab_7.Task_1;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start lab_7.1\n");

        List<String> stringOut = Files.readAllLines(Paths.get("Lab_7/Task_1/roguelike-input.csv"));
        int cols = stringOut.get(0).split(";").length;
        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < stringOut.size(); i++) {
            String[] splitedOut = stringOut.get(i).split(";");
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < cols; j++) {
                row.add(Integer.parseInt(splitedOut[j]));        
            }
            matrix.add(row);
        }

        for (List<Integer> list : matrix) {
            for (int obj : list) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }
        String path = "";
        int money = 0;

        for (int i = 0; i < cols - 1; i++) {
            if (i != 0) {
                path += "D";
            }
            money += matrix.get(i).get(0);
            System.err.println(money);
            System.err.println(path);
            for (int j = 0; j < cols - i; j++) {
                
                path += "R";
                money += matrix.get(i).get(j);
                for (int z = 0; z < cols - i - 1; z++) {
                    path += "D";

                }
            }
        }

        System.out.println("\nEnd lab_7.1");
    }
}
            // 0	1	1	0
            // 0	0	2	3
            // 4	-2	1	-1
            // -3	8	-6	0


// 0;1;1;0
// 0;0;2;3
// 4;-2;1;-1
// -3;8;-6;0