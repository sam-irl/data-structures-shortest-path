package edu.ossm.path;

public class Adjacency {
    private Vertex vertex;
    private int weight;

    public Adjacency(Vertex v, int w) {
        this.vertex = v;
        this.weight = w;
    }

    public Vertex getVertex() {
        return this.vertex;
    }

    public int getWeight() {
        return this.weight;
    }
}
