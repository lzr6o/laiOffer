package leetcode;

import java.util.Stack;

class BinarySearchTreeIterator {

	Stack<TreeNode> stack;

	BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<>();
		pushAll(root);
	}
	
	int next() {
		TreeNode node = stack.pop();
		pushAll(node.right);
		return node.val;
	}

	boolean hasNext() {
		return !stack.isEmpty();
	}

	void pushAll(TreeNode node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}
	
	public static void main(String[] args) {
		Integer[] nodes = {7, 3, 15, null, null, 9, 20};
		TreeNode root = TreeNode.build(nodes);
		BinarySearchTreeIterator bSTIterator = new BinarySearchTreeIterator(root);
		bSTIterator.next();
		bSTIterator.next();
		bSTIterator.hasNext();
		bSTIterator.next();
		bSTIterator.hasNext();
		bSTIterator.next();
		bSTIterator.hasNext();
		bSTIterator.next();
		bSTIterator.hasNext();
	}
}