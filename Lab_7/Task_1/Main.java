package Lab_7.Task_1;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static int line;
    static int cols;
    static int maxMoney = 0;
    static String bestPath = "";
    static List<List<Integer>> matrix = new ArrayList<List<Integer>>();

        public static void main(String[] args) throws Exception {
            String routeToDir = "Lab_7/Task_1/";
            List<String> stringOut = Files.readAllLines(Paths.get(routeToDir + "roguelike-input.csv"));
            line = stringOut.size();
            cols = stringOut.get(0).split(";").length;
            
            for (int i = 0; i < stringOut.size(); i++) {
                String[] splitedOut = stringOut.get(i).split(";");
                List<Integer> row = new ArrayList<>();
                
            for(int j = 0; j < cols; j++) {
                row.add(Integer.parseInt(splitedOut[j]));        
            }
            System.out.println(row);
            matrix.add(row);
        }
        
        for (List<Integer> list : matrix) {
            for (int obj : list) {
                System.out.print(obj + " ");
            }
            System.out.println();
        }

        findBestWay(0, 0, 0, "");

        String outPut = "BestPath: " + bestPath + "\nMoney: " + maxMoney;

        Files.write(Paths.get(routeToDir + "roguelike-output.txt"), outPut.getBytes());
        System.out.println(outPut);
    }


    public static void findBestWay(int i, int j, int money, String path) {
        int currentPosition = matrix.get(i).get(j);
        money += currentPosition;
        if (i == line - 1 && j == cols - 1) {
            if (money > maxMoney) {
                maxMoney = money;
                bestPath = path;
                return;
            }
        }

        if (i < line - 1) {
            findBestWay(i + 1, j, money, path + "D");
        }
        if (j < cols - 1) {
            findBestWay(i, j + 1, money, path + "R");
        }
    }
}
