package Code;

import java.util.Arrays;
import java.util.List;

class ReplaceWords {
	class Node {
		Node[] children;
		boolean isPre;
		String pre;

		Node() {
			children = new Node[26];
			isPre = false;
			pre = "";
		}
	}

	Node root;

	String replaceWords(List<String> dictionary, String sentence) {
		root = new Node();
		for (String str : dictionary) {
			insert(str);
		}
		String[] words = sentence.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			String res = search(word);
			sb.append(res).append(" ");
		}
		return sb.toString().trim();
	}

	String search(String word) {
		Node node = root;
		for (int i = 0; i < word.length(); i++) {
			int idx = word.charAt(i) - 'a';
			Node child = node.children[idx];
			if (child == null) {
				return word;
			} else if (child.isPre) {
				return child.pre;
			}
			node = node.children[idx];
		}
		return word;
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
		node.pre = word;
	}

	public static void main(String[] args) {
		ReplaceWords lzr = new ReplaceWords();
		List<String> dictionary = Arrays.asList("cat", "bat", "rat");
		String sentence = "the cattle was rattled by the battery";
		String res = lzr.replaceWords(dictionary, sentence);
		System.out.print(res);
	}
}