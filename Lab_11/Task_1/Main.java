package Lab_11.Task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Lab_11.Task_1.GraphLoader.Edge;
import Lab_11.Task_1.GraphLoader.Node;

public class Main {
    static double eucledeanDist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
    }
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
            edge.dist = eucledeanDist(u.lon, u.lat, v.lon, v.lat);
        }

         Dijkstra dijkstra = new Dijkstra(edges);

        long start = 1;
        long end = 9;

        dijkstra.computePaths(start);

        double distance = dijkstra.getDistance(end);
        if (distance == Double.MAX_VALUE) {
            System.out.println("Вершина " + end + " недостижима из " + start);
        } else {
            System.out.println("Кратчайшее расстояние от " + start + " до " + end + " = " + distance);
            List<Long> path = dijkstra.getPath(end);
            System.out.print("Путь: ");
            for (Long nodeId : path) {
                System.out.print(nodeId + " ");
            }
            System.out.println();
        }

        System.out.println("End Lab_11 \n");
    }
}
