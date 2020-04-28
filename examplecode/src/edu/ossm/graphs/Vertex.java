package edu.ossm.graphs;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable{
	private String name;
	private List<Adjacency> adj;
	private boolean known;
	private int dist;
	private Vertex path;
	
	public Vertex(String name) {
		this.name = name;
		adj = new ArrayList<Adjacency>();
		known = false;
		dist = Integer.MAX_VALUE;
		path = null;
	}

	public String getName() {
		return name;
	}
	
	public void addAdjacency(Vertex v, int w) {
		adj.add(new Adjacency(v,w));
	}
	
	public List<Adjacency> getAdjacencies() {
		return adj;
	}
	
	public boolean getKnown() {
		return known;
	}
	
	public void setKnown(boolean k) {
		known = k;
	}
	
	public int getDistance() {
		return dist;
	}
	
	public void setDistance(int d) {
		dist = d;
	}
	
	public Vertex getPath() {
		return path;
	}
	
	public void setPath(Vertex v) {
		path = v;
	}
	
	public String toString() {
		return name;
	}
	
	public int compareTo(Object o) {
		Vertex v = (Vertex) o;
		return ((Integer)dist).compareTo(((Integer)v.getDistance()));
	}
}
