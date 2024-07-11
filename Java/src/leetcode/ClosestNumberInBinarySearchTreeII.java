package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class ClosestNumberInBinarySearchTreeII {

	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int key) {
			this.key = key;
		}
	}

	int[] closestKValues(TreeNode root, double target, int k) {
		Deque<TreeNode> deque = new ArrayDeque<>();
		helper(root, target, k, deque);
		int size = deque.size();
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = deque.pollFirst().key;
		}
		return result;
	}

	void helper(TreeNode root, double target, int k, Deque<TreeNode> deque) {
		if (root == null) {
			return;
		}
		helper(root.left, target, k, deque);
		if (deque.size() < k) {
			deque.offerLast(root);
		} else {
			if (Math.abs(root.key - target) < Math.abs(deque.peekFirst().key - target)) {
				deque.pollFirst();
				deque.offerLast(root);
			} else {
				return;
			}
		}
		helper(root.right, target, k, deque);
	}

	public static void main(String[] args) {
		ClosestNumberInBinarySearchTreeII lzr = new ClosestNumberInBinarySearchTreeII();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		int[] result = lzr.closestKValues(tree, 4.0, 3);
		System.out.print(Arrays.toString(result));
	}
}