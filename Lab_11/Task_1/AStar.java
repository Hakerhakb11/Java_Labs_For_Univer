package Lab_11.Task_1;

import java.util.*;
import Lab_11.Task_1.GraphLoader.Edge;
import Lab_11.Task_1.GraphLoader.Node;

public class AStar {
    private Map<Long, List<Edge>> adjacencyList;
    private Map<Long, Long> prev;

    public AStar(List<Edge> edges, List<Node> nodes) {
        adjacencyList = new HashMap<>();
        for (Edge e : edges) {
            List<Edge> list = adjacencyList.get(e.u);
            if (list == null) {
                list = new ArrayList<>();
                adjacencyList.put(e.u, list);
            }
            list.add(e);

            Edge rev = new Edge(e.v, e.u);
            rev.dist = e.dist;
            List<Edge> listRev = adjacencyList.get(e.v);
            if (listRev == null) {
                listRev = new ArrayList<>();
                adjacencyList.put(e.v, listRev);
            }
            listRev.add(rev);
        }

    }

    public List<Long> getPath(long target) {
        if (!prev.containsKey(target)) {
            return null;
        }
        LinkedList<Long> path = new LinkedList<>();
        long curr = target;
        while (prev.containsKey(curr)) {
            path.addFirst(curr);
            curr = prev.get(curr);
        }
        path.addFirst(curr);
        return path;
    }

    // public double getDistance(long target) {
    //     return gScore.getOrDefault(target, Double.MAX_VALUE);
    // }
}