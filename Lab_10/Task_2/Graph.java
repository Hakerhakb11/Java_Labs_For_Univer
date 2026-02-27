package Lab_10.Task_2;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private List<List<Integer>> arrList = new ArrayList<>();
    private int N = 0;

    Graph(int N) {
        this.N = N;
        for (int i = 0; i < N; i++) {
            List<Integer> list = new ArrayList<>();
            arrList.add(list);
        }
    }

    public void insert(int value1, int value2) {
        arrList.get(value1).add(value2);
    }

    public void typoSort() {
        int[] status = new int[N];
        List<Integer> outPut = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (status[i] == GraphStatus.NON_VISITED.getStatus()) {
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
    
    private boolean dfs(int[] status, int u, List<Integer> outPut) {
        status[u] = GraphStatus.VISITED.getStatus();
        for (int v : arrList.get(u)) {
            if (status[v] == GraphStatus.VISITED.getStatus()) {
                return true;
            }
            if (status[v] == GraphStatus.NON_VISITED.getStatus()) {
                if (dfs(status, v, outPut)) {
                    return true;
                }
            }
        }
        status[u] = GraphStatus.COMPLETED.getStatus();
        outPut.addFirst(u);
        return false;
    }
}
