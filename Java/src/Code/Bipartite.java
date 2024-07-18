package Code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Bipartite {
	static class GraphNode {
		int key;
		List<GraphNode> neighbors;
		GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	
	boolean isBipartite(List<GraphNode> graph) {
		HashMap<GraphNode, Integer> visited = new HashMap<>();
		for (GraphNode node : graph) {
			if (!BFS(node, visited)) {
				return false;
			}
		}
		return true;
	}
	
	boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
		if (visited.containsKey(node)) {
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<>();
		queue.offer(node);
		visited.put(node, 0);
		while (!queue.isEmpty()) {
			GraphNode cur = queue.poll();
			int curGroup = visited.get(cur);
			int neiGroup = curGroup == 0 ? 1 : 0;
			for (GraphNode nei : cur.neighbors) {
				if (!visited.containsKey(nei)) {
					visited.put(nei, neiGroup);
					queue.offer(nei);
				} else if (visited.get(nei) != neiGroup) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String args[]) {
		Bipartite lzr = new Bipartite();
		List<GraphNode> graph = new ArrayList<>();
		GraphNode node1 = new GraphNode(1);
		GraphNode node2 = new GraphNode(2);
		GraphNode node3 = new GraphNode(3);
		node1.neighbors.add(node2);
		node1.neighbors.add(node3);
		node2.neighbors.add(node1);
		node2.neighbors.add(node3);
		node3.neighbors.add(node1);
		node3.neighbors.add(node2);
		graph.add(node1);
		graph.add(node2);
		graph.add(node3);
		boolean result = lzr.isBipartite(graph);
		System.out.print(result);
	}
}