package ImplementTriePrefixTree;

class Trie {
	class Node {
		Node[] children;
		boolean isPre;

		Node() {
			children = new Node[26];
			isPre = false;
		}
	}

	Node root;

	Trie() {
		root = new Node();
	}

	void insert(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new Node();
			}
			node = node.children[idx];
		}
		node.isPre = true;
	}

	boolean search(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			if (node.children[idx] == null) {
				return false;
			}
			node = node.children[idx];
		}
		return node.isPre;
	}

	boolean startsWith(String prefix) {
		Node node = root;
		for (int i = 0; i < prefix.length(); i++) {
			int idx = prefix.charAt(i) - 'a';
			if (node.children[idx] == null) {
				return false;
			}
			node = node.children[idx];
		}
		return true;
	}
	
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // return True
		System.out.println(trie.search("app"));     // return False
		System.out.println(trie.startsWith("app")); // return True
		trie.insert("app");
		System.out.println(trie.search("app"));     // return True
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */