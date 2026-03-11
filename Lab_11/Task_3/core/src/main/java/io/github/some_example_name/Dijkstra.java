package io.github.some_example_name;

import java.util.*;

import io.github.some_example_name.GraphLoader.Edge;

public class Dijkstra {
    private Map<Long, List<Edge>> connectionList;
    private Map<Long, Double> distBest;
    private Map<Long, Long> prev;
    private long startPos;

    public Dijkstra(List<Edge> edges) {
        connectionList = new HashMap<>();
        for (Edge e : edges) {
            List<Edge> list = connectionList.get(e.u);
            if (list == null) {
                list = new ArrayList<>();
                connectionList.put(e.u, list);
            }
            list.add(e);

            Edge rev = new Edge(e.v, e.u);
            rev.dist = e.dist;
            List<Edge> listRev = connectionList.get(e.v);
            if (listRev == null) {
                listRev = new ArrayList<>();
                connectionList.put(e.v, listRev);
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
            if (curr != start && distBest.get(curr) == Double.MAX_VALUE) {
                continue;
            }
            
            // obj - сосед.
            for (Edge obj : connectionList.getOrDefault(curr, Collections.emptyList())) {
                long neighbor = obj.v;
                double newDist = distBest.get(curr) + obj.dist;
                if (newDist < distBest.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distBest.put(neighbor, newDist);
                    prev.put(neighbor, curr);
                    pQueue.add(neighbor);
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
