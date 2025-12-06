package Lab_7.Task_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String routeToDir = "Lab_7/Task_3/";

        BufferedReader reader = new BufferedReader(new FileReader(routeToDir + "lis-input.txt"));
        String line;
        List<String> stringOut = new ArrayList<>();
        while((line = reader.readLine()) != null) {
            stringOut.add(line);
        }
        System.err.println(stringOut);
        LCS lcs = new LCS();
        int outPut = lcs.lcs2(stringOut.get(0), stringOut.get(1));

        System.err.println("\nResult: " + outPut);
        BufferedWriter writer = new BufferedWriter(new FileWriter(routeToDir + "list-output.txt"));
        writer.write("" + outPut);
        reader.close();
        writer.close();
    }
}
