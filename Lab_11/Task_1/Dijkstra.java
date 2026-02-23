package Lab_11.Task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Lab_11.Task_1.GraphLoader.Edge;

public class Dijkstra {
    private Map<Long, List<Edge>> adjacencyList;
    private Map<Long, Double> distBest;
    private Map<Long, Long> prev;
    private long startPos;

    public Dijkstra(List<Edge> edges) {
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

    public void computePaths(long start) {
        startPos = start;
        distBest = new HashMap<>();
        prev = new HashMap<>();
        PriorityQueue<Long> pQueue = new PriorityQueue<>(Comparator.comparingDouble(v -> distBest.getOrDefault(v, Double.MAX_VALUE)));
        distBest.put(start, 0.0);
        pQueue.add(start);

        while (!pQueue.isEmpty()) {
            long curr = pQueue.poll();
            if (curr != start && distBest.get(curr) == Double.MAX_VALUE){
                continue;
            }


            // obj - сосед.
            for (Edge obj : adjacencyList.get(curr)) {
                if (obj != null) {
                    long v = obj.v;
                    double newDist = distBest.get(curr) + obj.dist;
                    if (newDist < distBest.getOrDefault(v, Double.MAX_VALUE)) {
                        distBest.put(v, newDist);
                        prev.put(v, curr);
                        pQueue.add(v);
                    }
                }
            }
        }
    }

    public List<Long> getPath(long target) {
        if (!prev.containsKey(target) && target != startPos) {
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

    public double getDistance(long target) {
        return distBest.getOrDefault(target, Double.MAX_VALUE);
    }
}
