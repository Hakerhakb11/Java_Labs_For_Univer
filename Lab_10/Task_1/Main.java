package Lab_10.Task_1;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start Lab_10.1");

        Graph graph = new Graph();

        graph.insert(8, 1);
        graph.insert(1, 0);
        graph.insert(0, 2);
        graph.insert(1, 4);
        graph.insert(3, 6);
        graph.insert(3, 7);
        graph.insert(7, 9);

        graph.insert(74, 94);

        graph.insert(94, 4);

        graph.printGraph();

        System.out.println("\nEnd Lab_10.1 \n");
    }
}
// 8 1
// 1 0
// 0 2
// 1 4
// 3 6
// 3 7
// 7 9