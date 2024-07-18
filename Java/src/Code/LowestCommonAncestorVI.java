package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LowestCommonAncestorVI {
	static class KnaryTreeNode {
		int key;
		List<KnaryTreeNode> children;

		KnaryTreeNode(int key) {
			this.key = key;
			this.children = new ArrayList<>();
		}
	}

	KnaryTreeNode lowestCommonAncestor(KnaryTreeNode root, List<KnaryTreeNode> nodes) {
		Set<KnaryTreeNode> set = new HashSet<>(nodes);
		return helper(root, set);
	}

	KnaryTreeNode helper(KnaryTreeNode root, Set<KnaryTreeNode> set) {
		if (root == null || set.contains(root)) {
			return root;
		}
		KnaryTreeNode found = null;
		for (KnaryTreeNode child : root.children) {
			KnaryTreeNode node = helper(child, set);
			if (node == null) {
				continue;
			}
			if (found == null) {
				found = node;
			} else {
				return root;
			}
		}
		return found;
	}

	public static void main(String[] args) {
		LowestCommonAncestorVI lzr = new LowestCommonAncestorVI();
		KnaryTreeNode Node5 = new KnaryTreeNode(5);
		List<KnaryTreeNode> children = new ArrayList<>();
		KnaryTreeNode Node9 = new KnaryTreeNode(9);
		KnaryTreeNode Node12 = new KnaryTreeNode(12);
		children.add(Node9);
		children.add(Node12);
		Node5.children = children;
		children = new ArrayList<>();
		KnaryTreeNode Node1 = new KnaryTreeNode(1);
		KnaryTreeNode Node2 = new KnaryTreeNode(2);
		KnaryTreeNode Node3 = new KnaryTreeNode(3);
		children.add(Node1);
		children.add(Node2);
		children.add(Node3);
		Node9.children = children;
		children = new ArrayList<>();
		KnaryTreeNode Node14 = new KnaryTreeNode(14);
		children.add(Node14);
		Node12.children = children;
		List<KnaryTreeNode> nodes = new ArrayList<>();
		nodes.add(Node2);
		nodes.add(Node3);
		nodes.add(Node14);
		KnaryTreeNode result = lzr.lowestCommonAncestor(Node5, nodes);
		System.out.print(result.key);
	}
}