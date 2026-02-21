package Lab_11.Task_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Lab_11.Task_1.GraphLoader.Edge;

public class Dijkstra {
    private Map<Long, List<Edge>> adjacencyList;
    private Map<Long, Double> dist;
    private Map<Long, Long> prev;

    public Dijkstra(List<Edge> edges) {
        adjacencyList = new HashMap<>();
        // Строим список смежности (неориентированный граф)
        for (Edge e : edges) {
            adjacencyList.computeIfAbsent(e.u, k -> new ArrayList<>()).add(e);
            // создаём обратное ребро
            Edge rev = new Edge(e.v, e.u);
            rev.weight = e.weight;
            adjacencyList.computeIfAbsent(e.v, k -> new ArrayList<>()).add(rev);
        }
    }

    public void computePaths(long source) {
        dist = new HashMap<>();
        prev = new HashMap<>();
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> dist.getOrDefault(v, Double.MAX_VALUE)));
        dist.put(source, 0.0);
        pq.add(source);

        while (!pq.isEmpty()) {
            long u = pq.poll();
            // Если узел уже обработан с лучшим расстоянием (из-за дубликатов) – пропускаем
            if (u != source && dist.get(u) == Double.MAX_VALUE) continue;

            for (Edge e : adjacencyList.getOrDefault(u, Collections.emptyList())) {
                long v = e.v;
                double newDist = dist.get(u) + e.weight;
                if (newDist < dist.getOrDefault(v, Double.MAX_VALUE)) {
                    dist.put(v, newDist);
                    prev.put(v, u);
                    pq.add(v); // добавляем снова; старый дубликат будет проигнорирован позже
                }
            }
        }
    }

    public List<Long> getPath(long target) {
        if (!prev.containsKey(target) && target != dist.keySet().stream().findFirst().orElse(-1L)) {
            return null; // недостижима
        }
        LinkedList<Long> path = new LinkedList<>();
        long cur = target;
        while (prev.containsKey(cur)) {
            path.addFirst(cur);
            cur = prev.get(cur);
        }
        path.addFirst(cur); // добавляем источник
        return path;
    }

    public double getDistance(long target) {
        return dist.getOrDefault(target, Double.MAX_VALUE);
    }
}