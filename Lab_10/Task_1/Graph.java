package Lab_10.Task_1;

import java.util.*;

public class Graph {
    ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

    public void insert(int value1, int value2) {
        // ArrayList<Integer> temp = new ArrayList<>();
        if (!arrList.isEmpty()) {
            for (int i = 0; i < arrList.size(); i++) {
                if (arrList.get(i).contains(value1)) {
                    if (arrList.get(i).contains(value2)) {
                        return;
                    }
                    // temp = arrList.get(i);
                    arrList.get(i).add(value2);
                    return;
                }
                if (arrList.get(i).contains(value2)) {
                    arrList.get(i).add(value1);
                    return;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(value1);
        list.add(value2);
        arrList.add(list);
    }

    public void printGraph() {
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("\nКомпонента связности " + (i + 1));
            for (int j = 0; j < arrList.get(i).size(); j++) {
                System.out.print(arrList.get(i).get(j) + ", ");
            }
        }
    }
}
