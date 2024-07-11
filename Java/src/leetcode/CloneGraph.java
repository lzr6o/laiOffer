package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CloneGraph {

	class Node {
		int val;
		List<Node> neighbors;

		Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}
		Map<Node, Node> map = new HashMap<>();
		return dfs(node, map);
	}
	
	Node dfs(Node node, Map<Node, Node> map) {
		if (map.containsKey(node)) {
			return map.get(node);
		}
		Node clone = new Node(node.val);
		map.put(node, clone);
		for (Node nei : node.neighbors) {
			clone.neighbors.add(dfs(nei, map));
		}
		return clone;
	}

	public static void main(String[] args) {
		CloneGraph lzr = new CloneGraph();
		
	}
}