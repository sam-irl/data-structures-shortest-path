package edu.ossm.path;

import java.util.ArrayList;

import java.util.PriorityQueue;

/**
 * Implementation of Dijkstra's Algorithm to find the shortest
 * path between two nodes on an unweighted graph.
 * Based on the sample code and the pseudocode in figure 9.30.
 */
public class ShortestPathUnweighted {
    public static void main(String[] args) {
        Vertex v1, v2, v3, v4, v5, v6, v7;
        v1 = new Vertex("v1");
        v2 = new Vertex("v2");
        v3 = new Vertex("v3");
		v4 = new Vertex("v4");
		v5 = new Vertex("v5");
		v6 = new Vertex("v6");
        v7 = new Vertex("v7");
        
        // now here is a maze thing, graph, whatever you call it
        // this is honestly the same as in ShortestPathWeighted but the weights are all 1
        v1.addAdjacency(v2, 1);
        v1.addAdjacency(v3, 1);
        v1.addAdjacency(v5, 1);

        v2.addAdjacency(v1, 1);
        v2.addAdjacency(v4, 1);
        v2.addAdjacency(v5, 1);

        v3.addAdjacency(v1, 1);
        v3.addAdjacency(v5, 1);
        v3.addAdjacency(v6, 1);

        v4.addAdjacency(v2, 1);
        v4.addAdjacency(v5, 1);
        v4.addAdjacency(v7, 1);

        v5.addAdjacency(v1, 1);
        v5.addAdjacency(v2, 1);
        v5.addAdjacency(v3, 1);
        v5.addAdjacency(v4, 1);
        v5.addAdjacency(v6, 1);
        v5.addAdjacency(v7, 1);

        v6.addAdjacency(v3, 1);
        v6.addAdjacency(v5, 1);
        v6.addAdjacency(v7, 1);

        v7.addAdjacency(v4, 1);
        v7.addAdjacency(v5, 1);
        v7.addAdjacency(v6, 1);

        ArrayList<Vertex> graph =  new ArrayList<Vertex>();

        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);
        graph.add(v6);
        graph.add(v7);

        shortestPath(graph, v7);

        printPath(v1);
		System.out.println("");
		printPath(v2);
		System.out.println("");
		printPath(v3);
		System.out.println("");
		printPath(v4);
		System.out.println("");
		printPath(v5);
		System.out.println("");
		printPath(v6);
		System.out.println("");
		printPath(v7);
		System.out.println("");
    }

    public static void shortestPath(ArrayList<Vertex> graph, Vertex start) {
        PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
        start.setDistance(0);
        q.add(start);

        while (!q.isEmpty()) {
            Vertex v = q.poll();

            for (Adjacency a : v.getAdjacencies()) {
                if (a.getVertex().getDistance() == Integer.MAX_VALUE) {
                    a.getVertex().setDistance(v.getDistance() + 1);
                    a.getVertex().setPath(v);
                    q.add(a.getVertex());
                }
            }
        }
    }

    public static void printPath(Vertex v) {
        if (v.getPath() != null) {
            printPath(v.getPath());
            System.out.print(" to ");
        }
        System.out.print(v);
    }
}
