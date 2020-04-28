package edu.ossm.path;

import java.util.ArrayList;

import java.util.PriorityQueue;

/**
 * Implementation of Dijkstra's Algorithm to find the shortest
 * path between two nodes on a negative-edge-weighted graph.
 * Based on the sample code and the pseudocode in figure 9.30.
 */
public class ShortestPathNegativeWeighted {
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
        // this is also the same as in ShortestPathWeighted but the weights on the edge are all negative
        v1.addAdjacency(v2, -3);
        v1.addAdjacency(v3, -5);
        v1.addAdjacency(v5, 10);

        v2.addAdjacency(v1, -3);
        v2.addAdjacency(v4, -2);
        v2.addAdjacency(v5, 7);

        v3.addAdjacency(v1, -5);
        v3.addAdjacency(v5, 3);
        v3.addAdjacency(v6, -1);

        v4.addAdjacency(v2, -2);
        v4.addAdjacency(v5, 1);
        v4.addAdjacency(v7, -4);

        v5.addAdjacency(v1, 10);
        v5.addAdjacency(v2, 7);
        v5.addAdjacency(v3, 3);
        v5.addAdjacency(v4, 1);
        v5.addAdjacency(v6, 8);
        v5.addAdjacency(v7, 6);

        v6.addAdjacency(v3, -1);
        v6.addAdjacency(v5, 8);
        v6.addAdjacency(v7, -9);

        v7.addAdjacency(v4, -4);
        v7.addAdjacency(v5, 6);
        v7.addAdjacency(v6, -9);

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
            v.addDequeued();

            for (Adjacency a : v.getAdjacencies()) {
                int edgeCost = a.getWeight();
                if (v.getDistance() + edgeCost < a.getVertex().getDistance()) {
                    a.getVertex().setDistance(v.getDistance() + edgeCost);
                    a.getVertex().setPath(v);
                    if (!q.contains(a.getVertex())) {
                        q.add(a.getVertex());
                    }
                }
            }

            for (Vertex vtx : q) {
                if (vtx.getTimesDequeued() > graph.size()) {
                    return;
                }
            }
        }
    }

    public static void printPath(Vertex v) {
        if (v.getPath() != null) {
            try {
                printPath(v.getPath());
            } catch(Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            System.out.print(" to ");
        }
        System.out.print(v);
    }
}
