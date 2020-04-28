package edu.ossm.graphs;

public class Adjacency {
	private Vertex vertex;
	private int weight;

	public Adjacency(Vertex vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	public Vertex getVertex() {
		return vertex;
	}
	
	public int getWeight() {
		return weight;
	}
}
