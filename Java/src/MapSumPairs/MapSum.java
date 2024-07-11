package MapSumPairs;

import java.util.HashMap;
import java.util.Map;

class MapSum {
	class Node {
		Node[] children;
		int val;

		Node() {
			children = new Node[26];
		}
	}

	Node root;
	Map<String, Integer> map;

	MapSum() {
		root = new Node();
		map = new HashMap<>();
	}

	void insert(String key, int val) {
		int dif = val - map.getOrDefault(key, 0);
		map.put(key, val);
		Node node = root;
		for (Character c : key.toCharArray()) {
			int idx = c - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new Node();
			}
			node.children[idx].val += dif;
			node = node.children[idx];
		}
	}

	int sum(String prefix) {
		Node node = root;
		int idx = 0;
		for (int i = 0; i < prefix.length(); i++) {
			idx = prefix.charAt(i) - 'a';
			if (node.children[idx] == null) {
				return 0;
			}
			if (i == prefix.length() - 1) {
				break;
			}
			node = node.children[idx];
		}
		return node.children[idx].val;
	}

	public static void main(String[] args) {
		MapSum mapSum = new MapSum();
		mapSum.insert("a", 3);
		System.out.println(mapSum.sum("ap"));
		mapSum.insert("b", 2);
		System.out.println(mapSum.sum("a"));
	}
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */