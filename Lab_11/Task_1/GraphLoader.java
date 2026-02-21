package Lab_11.Task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class GraphLoader {
    int CANVAS_WIDTH = 1200;
    int CANVAS_HEIGHT = 800;
    
    class Node {
        long id;
        double lon;
        double lat;
    
        double x;
        double y;
    
        Node(long id, double lon, double lat) {
            this.id = id;
            this.lon = lon;
            this.lat = lat;
        }   
    }
    
    class Edge {
        long u;
        long v;
        
        double ux;
        double uy;
        
        double vx;
        double vy;
        double weight = eucledean_dist(ux, vx, uy, vy);

        long dist; // расстояние между u-v

        Edge(long u, long v) {
            this.u = u;
            this.v = v;
        }
    }

    double eucledean_dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y1 - y2, 2));
    }


    ArrayList<Node> readNodes(String path) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(path));

        reader.readLine();

        ArrayList<Node> nodes = new ArrayList<>();
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] splited = line.split(",");

            long id = Long.parseLong(splited[0].trim());
            double lon = Double.parseDouble(splited[1].trim());
            double lat = Double.parseDouble(splited[2].trim());

            nodes.add(new Node(id, lon, lat));
        }
        reader.close();
        return nodes;
    }

    ArrayList<Edge> readEdges(String path) throws Exception {
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