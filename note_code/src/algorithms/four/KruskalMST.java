package algorithms.four;

import algorithms.one.*;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;

public class KruskalMST
{
	private Queue<Edge> mst;
	public KruskalMST(EdgeWeightedGraph G)
	{
		mst = new Queue<Edge>();
		MinPQ<Edge> pq = new MinPQ<Edge>();
		for(Edge e : G.edges())
			pq.insert(e);
		UF uf = new UF(G.V());
		
		while(!pq.isEmpty() && mst.size() < G.V()-1)
		{
			Edge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if(uf.connected(v, w)) 
				continue;
			uf.union(v, w);
			mst.enqueue(e);
			
		}
		
	}
	
	public Iterable<Edge> edges()
	{return mst;}
	
}
