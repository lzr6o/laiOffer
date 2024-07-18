package LeetCode.ImplementMagicDictionary;

class MagicDictionary {
	class Node {
		Node[] children;
		boolean isWord;
		
		Node() {
			children = new Node[26];
			isWord = false;
		}
	}
	
	Node root;
	
	MagicDictionary() {
		root = new Node();
	}

	void buildDict(String[] dictionary) {
		Node node = root;
		for (String word : dictionary) {
			for (Character c : word.toCharArray()) {
				int idx = c - 'a';
				if (node.children[idx] == null) {
					node.children[idx] = new Node();
				}
				node = node.children[idx];
			}
			node.isWord = true;
		}
	}

	boolean search(String searchWord) {
		Node node = root;
		int cnt = 0;
		for (int i = 0; i < searchWord.length(); i++) {
			int idx = searchWord.charAt(i) - 'a';
			if (node.children[idx] == null) {
				if (cnt > 1) {
					return false;
				} else if (i + 1 <= searchWord.length() - 1) {
					i++;
					cnt++;
					Character c = searchWord.charAt(i);
					int pos = find(node, c);
					if (pos != -1) {
						node = node.children[pos].children[c - 'a'];
						continue;
					} else {
						return false;
					}
				}
			}
			node = node.children[idx];
		}
		return node.isWord && cnt == 1;
	}
	
	int find(Node node, Character c) {
		int idx = c - 'a';
		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null && node.children[i].children[idx] != null) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		MagicDictionary magicDictionary = new MagicDictionary();
		magicDictionary.buildDict(new String[] { "hello","hallo","leetcode" });
		System.out.println(magicDictionary.search("hello")); // return False
		System.out.println(magicDictionary.search("hhllo")); // We can change the second 'h' to 'e' to match "hello" so we return True
		System.out.println(magicDictionary.search("hell")); // return False
		System.out.println(magicDictionary.search("leetcoded")); // return False
	}
}