package io.github.some_example_name;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class GraphLoader {
    int CANVAS_WIDTH = 1200;
    int CANVAS_HEIGHT = 800;
    
    public static class Node {
        public long id;
        public float lon;
        public float lat;
    
        public double x;
        public double y;
    
        Node(long id, float lon, float lat) {
            this.id = id;
            this.lon = lon;
            this.lat = lat;
        }   
    }
    
    public static class Edge {
        public long u;
        public long v;
        
        public double ux;
        public double uy;
        
        public double vx;
        public double vy;

        public double dist; // расстояние между u-v

        Edge(long u, long v) {
            this.u = u;
            this.v = v;
        }
    }
    
    public double eucledeanDist(Node u, Node v) {
        double dx = u.lon - v.lon;
        double dy = u.lat - v.lat;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // public double eucledeanDist(double x1, double y1, double x2, double y2) {
    //     return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
    // }

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
