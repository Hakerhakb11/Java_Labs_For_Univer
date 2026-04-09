package io.github.some_example_name;
public class Edge {
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
