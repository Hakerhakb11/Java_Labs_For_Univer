package Lab_7.Task_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start lab_7.3");
        
        String routeToDir = "Lab_7/Task_3/";

        BufferedReader reader = new BufferedReader(new FileReader(routeToDir + "lis-input.txt"));
        String line;
        List<String> stringOut = new ArrayList<>();
        while((line = reader.readLine()) != null) {
            stringOut.add(line);
        }

        System.err.println(stringOut);


        
        

        String outPut = "CD 'test'";

        System.err.println("\nres: " + outPut);
        BufferedWriter writer = new BufferedWriter(new FileWriter(routeToDir + "list-output.txt"));
        writer.write(outPut);
        reader.close();
        writer.close();

        System.out.println("\nEnd lab_7.3");
    }
}
