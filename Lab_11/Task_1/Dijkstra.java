package Lab_11.Task_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
// import java.util.Collections;

import Lab_11.Task_1.GraphLoader.Edge;

public class Dijkstra {
    private Map<Long, List<Edge>> adjacencyList;
    private Map<Long, Double> distStart;
    private Map<Long, Long> prev;

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
            listRev.add(e);
        }
    }

    public void computePaths(long source) {
        distStart = new HashMap<>();
        prev = new HashMap<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> distStart.getOrDefault(v, Double.MAX_VALUE)));
        distStart.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            long u = pq.poll();
            if (u != source && distStart.get(u) == Double.MAX_VALUE) continue;

            // for (Edge e : adjacencyList.getOrDefault(u, Collections.emptyList())) {
            for (Edge e : adjacencyList.get(u)) {
                if (e != null) {
                    long v = e.v;
                    double newDist = distStart.get(u) + e.dist;
                    if (newDist < distStart.getOrDefault(v, Double.MAX_VALUE)) {
                        distStart.put(v, newDist);
                        prev.put(v, u);
                        pq.add(v);
                    }
                }
            }
        }
    }

    public List<Long> getPath(long target) {
        if (!prev.containsKey(target) && target != distStart.keySet().stream().findFirst().orElse(-1L)) {
            return null;
        }
        LinkedList<Long> path = new LinkedList<>();
        long cur = target;
        while (prev.containsKey(cur)) {
            path.addFirst(cur);
            cur = prev.get(cur);
        }
        path.addFirst(cur);
        return path;
    }

    public double getDistance(long target) {
        return distStart.getOrDefault(target, Double.MAX_VALUE);
    }
}