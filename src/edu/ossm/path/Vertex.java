package edu.ossm.path;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable {
    private String name;
    private int dist;
    private List<Adjacency> adjacent;
    private boolean known;
    private Vertex path;
    private int timesDequeued;

    public Vertex(String name) {
        this.name = name;
        this.dist = Integer.MAX_VALUE;
        this.adjacent = new ArrayList<Adjacency>();
        this.known = false;
        this.timesDequeued = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.dist;
    }

    public void setDistance(int nextDistance) {
        this.dist = nextDistance;
    }

    public List<Adjacency> getAdjacencies() {
        return this.adjacent;
    }

    public void addAdjacency(Vertex v, int weight) {
        this.adjacent.add(new Adjacency(v, weight));
    }

    public boolean isKnown() {
        return this.known;
    }

    public void setKnown(boolean isKnown) {
        this.known = isKnown;
    }

    public Vertex getPath() {
        return this.path;
    }

    public void setPath(Vertex nextPath) {
        this.path = nextPath;
    }

    public String toString() {
        return this.name;
    }

    public int compareTo(Object o) {
        Vertex v = (Vertex) o;
        return ((Integer) this.dist).compareTo((Integer) v.getDistance());
    }

    public int getTimesDequeued() {
        return this.timesDequeued;
    }

    public void addDequeued() {
        this.timesDequeued++;
    }
}
