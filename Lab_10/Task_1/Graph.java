package Lab_10.Task_1;

import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

    Graph(int N) {
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(i);
            arrList.add(list);
        }
    }

    public void insert(int value1, int value2) {
        if (!arrList.isEmpty()) {
            for (int i = 0; i < arrList.size(); i++) {
                if (arrList.get(i).contains(value1)) {
                    if (arrList.get(i).contains(value2)) {
                        return;
                    }
                    for (int j = i; j < arrList.size(); j++) {
                        if (arrList.get(j).contains(value2)) {
                            arrList.get(i).addAll(arrList.get(j));
                            arrList.remove(j);
                            return;
                        }
                    }
                    arrList.get(i).add(value2);
                    return;
                }
                if (arrList.get(i).contains(value2)) {
                    for (int j = i; j < arrList.size(); j++) {
                        if (arrList.get(j).contains(value1)) {
                            arrList.get(i).addAll(arrList.get(j));
                            arrList.remove(j);
                            return;
                        }
                    }
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
        System.out.print("\n-----------------------------");
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println("\nКомпонента связности " + (i + 1));
            for (int j = 0; j < arrList.get(i).size(); j++) {
                System.out.print(arrList.get(i).get(j) + ", ");
            }
        }
    }
}
