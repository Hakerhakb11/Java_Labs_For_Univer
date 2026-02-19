package Lab_10.Task_1;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.insert(8, 1);
        graph.insert(1, 0);
        graph.insert(0, 2);
        graph.insert(1, 4);
        graph.insert(3, 6);
        graph.insert(3, 7);
        graph.insert(7, 9);
        
        graph.printGraph();

        graph.insert(3, 4);

        graph.printGraph();
    }
}
