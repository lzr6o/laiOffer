package Code;

import java.util.HashMap;
import java.util.HashSet;

class FirstNonRepeatingCharacterInStream {

	class Node {
		Node prev;
		Node next;
		Character ch;

		Node(Character ch) {
			this.ch = ch;
		}
	}

	Node head;
	Node tail;
	HashMap<Character, Node> singled;
	HashSet<Character> repeated;

	FirstNonRepeatingCharacterInStream() {
		tail = new Node(null);
		tail.next = tail.prev = tail;
		head = tail;
		singled = new HashMap<Character, Node>();
		repeated = new HashSet<Character>();
	}

	void read(char ch) {
		if (repeated.contains(ch)) {
			return;
		}
		Node node = singled.get(ch);
		if (node == null) {
			node = new Node(ch);
			append(node);
		} else {
			remove(node);
		}
	}

	void append(Node node) {
		singled.put(node.ch, node);
		tail.next = node;
		node.prev = tail;
		node.next = head;
		tail = tail.next;
	}

	void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		if (node == tail) {
			tail = node.prev;
		}
		node.prev = node.next = null;
		repeated.add(node.ch);
		singled.remove(node.ch);
	}

	Character firstNonRepeating() {
		if (head == tail) {
			return null;
		}
		return head.next.ch;
	}

	public static void main(String[] args) {
		FirstNonRepeatingCharacterInStream lzr = new FirstNonRepeatingCharacterInStream();
		
	}
}