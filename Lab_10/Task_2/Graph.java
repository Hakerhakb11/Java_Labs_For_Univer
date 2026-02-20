package Lab_10.Task_2;

import java.util.ArrayList;

public class Graph {
    ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
    int N = 0;

    Graph(int N) {
        this.N = N;
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            arrList.add(list);
        }
    }

    public void insert(int value1, int value2) {
        arrList.get(value1).add(value2);
    }

    public void typoSort() {
        int[] status = new int[N];
        ArrayList<Integer> outPut = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (status[i] == 0) {
                if (dfs(status, i, outPut)) {
                    System.out.println("Обнаружен цикл, сортировка невозможна.");
                    return;
                }
            }
        }
        System.out.println("Отсортированный Граф:");
        for (int j : outPut) {
            System.out.print(j + ", ");
        }
        return;
    }
    
    private boolean dfs(int[] status, int u, ArrayList<Integer> outPut) {
        status[u] = 1;
        for (int v : arrList.get(u)) {
            if (status[v] == 1) {
                return true;
            }
            if (status[v] == 0) {
                if (dfs(status, v, outPut)) {
                    return true;
                }
            }
        }
        status[u] = 2;
        outPut.addFirst(u);
        return false;
    }
}
