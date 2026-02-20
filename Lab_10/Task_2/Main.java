package Lab_10.Task_2;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(6);

        graph.insert(5, 0);
        graph.insert(5, 2);
        graph.insert(2, 3);
        graph.insert(3, 1);
        graph.insert(4, 0);
        graph.insert(4, 1);

        graph.typoSort();
        // graph.insert(8, 1);
        // graph.insert(1, 0);
        // graph.insert(0, 2);
        // graph.insert(1, 4);
        // graph.insert(3, 6);
        // graph.insert(3, 7);
        // graph.insert(7, 9);
        
        // graph.printGraph();

        // graph.insert(3, 4);

        // graph.printGraph();
    }
}