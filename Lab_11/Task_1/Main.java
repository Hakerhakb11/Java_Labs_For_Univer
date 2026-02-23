package Lab_11.Task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Lab_11.Task_1.GraphLoader.Edge;
import Lab_11.Task_1.GraphLoader.Node;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start Lab_11 \n");

        GraphLoader loader = new GraphLoader();

        ArrayList<Node> nodes = loader.readNodes("Lab_11/simple/nodes.csv");
        ArrayList<Edge> edges = loader.readEdges("Lab_11/simple/edges.csv");
        
        Map<Long, Node> nodeMap = new HashMap<>();
        for (Node node : nodes) {
            nodeMap.put(node.id, node);
        }

        System.out.println("\nNodes:");
        for (var node : nodes) {
            System.out.println(node.id + " " + node.lon + " " + node.lat);
        }

        System.out.println("\nEdges:");
        for (var edge : edges) {
            System.out.println(edge.u + " " + edge.v);
            Node u = nodeMap.get(edge.u);
            Node v = nodeMap.get(edge.v);
            edge.dist = loader.eucledeanDist(u.lon, u.lat, v.lon, v.lat);
        }

         Dijkstra dijkstra = new Dijkstra(edges);

        long start = 1;
        long end = 9;

        dijkstra.computePaths(start);

        double dist = dijkstra.getDistance(end);
        if (dist == Double.MAX_VALUE) {
            System.out.println("Путь не найден.");
        } else {
            System.out.println("Кратчайшее расстояние = " + dist);
            List<Long> path = dijkstra.getPath(end);
            System.out.print("Путь: ");
            for (Long i : path) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        System.out.println("End Lab_11 \n");
    }
}
