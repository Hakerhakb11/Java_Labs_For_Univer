package io.github.some_example_name;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class GraphLoader {

    public double eucledeanDist(Node u, Node v) {
        double dx = u.lon - v.lon;
        double dy = u.lat - v.lat;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public ArrayList<Node> readNodes(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        reader.readLine();

        ArrayList<Node> nodes = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] splited = line.split(",");

            long id = Long.parseLong(splited[0].trim());
            float lon = Float.parseFloat(splited[1].trim());
            float lat = Float.parseFloat(splited[2].trim());

            nodes.add(new Node(id, lon, lat));
        }
        reader.close();
        return nodes;
    }

    public ArrayList<Edge> readEdges(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        reader.readLine();

        ArrayList<Edge> edges = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] splited = line.split(",");

            long u = Long.parseLong(splited[0].trim());
            long v = Long.parseLong(splited[1].trim());

            edges.add(new Edge(u, v));
        }
        reader.close();
        return edges;
    }
}
