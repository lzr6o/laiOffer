package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DeepCopyUndirectedGraph {
	class GraphNode {
		int key;
		List<GraphNode> neighbors;
		GraphNode(int key) {
			this.key = key;
			this.neighbors = new ArrayList<GraphNode>();
		}
	}
	
	List<GraphNode> copy(List<GraphNode> graph) {
		if (graph == null) {
			return null;
		}
		HashMap<GraphNode, GraphNode> map = new HashMap<>();
		for (GraphNode node : graph) {
			if (!map.containsKey(node)) {
				map.put(node, new GraphNode(node.key));
				dfs(node, map);
			}
		}
		return new ArrayList<GraphNode>(map.values());
	}
	
	void dfs(GraphNode seed, HashMap<GraphNode, GraphNode> map) {
		GraphNode copy = map.get(seed);
		for (GraphNode nei : seed.neighbors) {
			if (!map.containsKey(nei)) {
				map.put(nei, new GraphNode(nei.key));
				dfs(nei, map);
			}
			copy.neighbors.add(map.get(nei));
		}
	}
	
	public static void main(String[] args) {
		DeepCopyUndirectedGraph lzr = new DeepCopyUndirectedGraph();
		
	}
}