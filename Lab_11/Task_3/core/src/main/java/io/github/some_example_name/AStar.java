package io.github.some_example_name;

import java.util.*;
import io.github.some_example_name.GraphLoader.Edge;
import io.github.some_example_name.GraphLoader.Node;

public class AStar implements PathSearching {
    private Map<Long, List<Edge>> connectionList;
    private Map<Long, Node> nodeMap;
    private Map<Long, Double> distBest;
    private Map<Long, Double> fScore;
    private Map<Long, Long> prev;

    public AStar(List<Edge> edges, List<Node> nodes) {
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
        nodeMap = new HashMap<>();
        for (Node i : nodes) {
            nodeMap.put(i.id, i);
        }
    }

    @Override
    public void computePaths(long start, long target) {
        distBest = new HashMap<>();
        fScore = new HashMap<>();
        prev = new HashMap<>();

        PriorityQueue<Long> pQueue = new PriorityQueue<>(
                Comparator.comparingDouble(v -> fScore.getOrDefault(v, Double.MAX_VALUE)));

        distBest.put(start, 0.0);
        fScore.put(start, eucledeanDist(start, target));
        pQueue.add(start);

        while (!pQueue.isEmpty()) {
            long current = pQueue.poll();
            if (current == target) {
                return;
            }

            // obj - сосед.
            for (Edge obj : connectionList.getOrDefault(current, Collections.emptyList())) {
                long neighbor = obj.v;
                double newDist = distBest.get(current) + obj.dist;
                if (newDist < distBest.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    prev.put(neighbor, current);
                    distBest.put(neighbor, newDist);
                    fScore.put(neighbor, newDist + eucledeanDist(neighbor, target));
                    pQueue.add(neighbor);
                }
            }
        }
    }

    private double eucledeanDist(long a, long b) {
        Node u = nodeMap.get(a);
        Node v = nodeMap.get(b);
        if (u == null || v == null) {
            return Double.MAX_VALUE;
        }
        double dx = u.lon - v.lon;
        double dy = u.lat - v.lat;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public List<Long> getPath(long target) {
        if (!distBest.containsKey(target)) {
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

    @Override
    public double getDistance(long target) {
        return distBest.getOrDefault(target, Double.MAX_VALUE);
    }
}
