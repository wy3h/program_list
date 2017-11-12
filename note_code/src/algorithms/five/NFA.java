package algorithms.five;

import java.util.Stack;

import edu.princeton.cs.algs4.Digraph;

public class NFA
{
	private char[] re;
	private Digraph G;
	private int M;
	
	public NFA(String regexp)
	{
		Stack<Integer> ops = new Stack<Integer>();
		re = regexp.toCharArray();
		M = re.length;
		G = new Digraph(M + 1);
		
		for(int i = 0; i < M; i++)
		{
			int lp = i;
			if(re[i] == 'C' || re[i] == '|')
				ops.push(i);
			else if(re[i] == ')')
			{
				int or = ops.pop();
				if(re[or] == '|')
				{
					lp = ops.pop();
					G.addEdge(lp, or+1);
					G.addEdge(or, i);
				}
				else
					lp = or;
			}
			if(i < M-1 && re[i+1] == '*')
			{
				G.addEdge(lp, i+1);
				G.addEdge(i+1, lp);
			}
			if(re[i] == '(' || re[i] == '*' || re[i] == ')')
				G.addEdge(i, i+1);
		}
	}
	
}
