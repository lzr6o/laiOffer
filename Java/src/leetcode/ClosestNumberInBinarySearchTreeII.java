package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class ClosestNumberInBinarySearchTreeII {
	int[] closestKValues(TreeNode root, double target, int k) {
		Deque<TreeNode> deque = new ArrayDeque<>();
		dfs(root, target, k, deque);
		int size = deque.size();
		int[] res = new int[size];
		for (int i = 0; i < size; i++) {
			res[i] = deque.pollFirst().val;
		}
		return res;
	}

	void dfs(TreeNode root, double target, int k, Deque<TreeNode> deque) {
		if (root == null) {
			return;
		}
		dfs(root.left, target, k, deque);
		if (deque.size() < k) {
			deque.offerLast(root);
		} else {
			if (Math.abs(root.val - target) < Math.abs(deque.peekFirst().val - target)) {
				deque.pollFirst();
				deque.offerLast(root);
			} else {
				return;
			}
		}
		dfs(root.right, target, k, deque);
	}

	public static void main(String[] args) {
		ClosestNumberInBinarySearchTreeII lzr = new ClosestNumberInBinarySearchTreeII();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		int[] res = lzr.closestKValues(tree, 4.0, 3);
		System.out.print(Arrays.toString(res));
	}
}