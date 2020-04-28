package edu.ossm.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vertex v1, v2, v3, v4, v5, v6, v7;
		v1 = new Vertex("v1");
		v2 = new Vertex("v2");
		v3 = new Vertex("v3");
		v4 = new Vertex("v4");
		v5 = new Vertex("v5");
		v6 = new Vertex("v6");
		v7 = new Vertex("v7");

		v1.addAdjacency(v2, 2);
		v1.addAdjacency(v3, 4);
		v1.addAdjacency(v4, 1);

		v2.addAdjacency(v1, 2);
		v2.addAdjacency(v4, 3);
		v2.addAdjacency(v5, 10);

		v3.addAdjacency(v1, 4);
		v3.addAdjacency(v4, 2);
		v3.addAdjacency(v6, 5);

		v4.addAdjacency(v1, 1);
		v4.addAdjacency(v2, 3);
		v4.addAdjacency(v3, 2);
		v4.addAdjacency(v5, 2);
		v4.addAdjacency(v6, 8);
		v4.addAdjacency(v7, 4);

		v5.addAdjacency(v2, 10);
		v5.addAdjacency(v4, 2);
		v5.addAdjacency(v7, 6);

		v6.addAdjacency(v3, 5);
		v6.addAdjacency(v4, 8);
		v6.addAdjacency(v7, 1);

		v7.addAdjacency(v4, 4);
		v7.addAdjacency(v5, 6);
		v7.addAdjacency(v6, 1);

		ArrayList<Vertex> weightedGraph = new ArrayList<Vertex>();
		weightedGraph.add(v1);
		weightedGraph.add(v2);
		weightedGraph.add(v3);
		weightedGraph.add(v4);
		weightedGraph.add(v5);
		weightedGraph.add(v6);
		weightedGraph.add(v7);
		
		dijkstra( weightedGraph, v7 );
		printPath( v1 );
		System.out.println("");
		printPath( v2 );
		System.out.println("");
		printPath( v3 );
		System.out.println("");
		printPath( v4 );
		System.out.println("");
		printPath( v5 );
		System.out.println("");
		printPath( v6 );
		System.out.println("");
		printPath( v7 );
		System.out.println("");
	}

	public static void dijkstra( List<Vertex> graph, Vertex s ) {
		for ( Vertex v: graph ) {
			v.setDistance(Integer.MAX_VALUE);
			v.setKnown(false);
		}
		
		s.setDistance(0);
		
		PriorityQueue<Vertex> unknowns = new PriorityQueue<>();
		for ( Vertex v: graph )
		{
			if ( ! v.getKnown() )
			{
				unknowns.add(v);
			}
		}
		
		while ( ! unknowns.isEmpty() )
		{
			Vertex v = unknowns.poll();
			v.setKnown(true);
			
			for (Adjacency adj: v.getAdjacencies())
			{
				Vertex w = adj.getVertex();
				if ( ! w.getKnown() )
				{
					int cvw = adj.getWeight();
					
					if( v.getDistance() + cvw < w.getDistance())
					{
						w.setDistance(v.getDistance() + cvw);
						w.setPath(v);
					}
				}
			}
			
			unknowns.clear();
			for ( Vertex vertex: graph )
			{
				if ( ! vertex.getKnown() )
				{
					unknowns.add(vertex);
				}
			}
		}
	}
	
	public static void printPath( Vertex v ) {
		if ( v.getPath() != null ) {
			printPath(v.getPath());
			System.out.print( " to " );
		}
		System.out.print( v );
	}
}
