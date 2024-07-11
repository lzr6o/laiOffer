package leetcode;

import java.util.HashSet;
import java.util.Set;

class BinaryTreePathSumToTargetIII {
	boolean exist(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
		Set<Integer> prefixSums = new HashSet<>();
		prefixSums.add(0);
		return helper(root, prefixSums, 0, sum);
	}

	boolean helper(TreeNode root, Set<Integer> prefixSums, int prevSum, int sum) {
		prevSum += root.val;
		if (prefixSums.contains(prevSum - sum)) {
			return true;
		}
		boolean needRemove = prefixSums.add(prevSum);
		if (root.left != null && helper(root.left, prefixSums, prevSum, sum)) {
			return true;
		}
		if (root.right != null && helper(root.right, prefixSums, prevSum, sum)) {
			return true;
		}
		if (needRemove) {
			prefixSums.remove(prevSum);
		}
		return false;
	}

	public static void main(String[] args) {
		BinaryTreePathSumToTargetIII lzr = new BinaryTreePathSumToTargetIII();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		tree.right.left.left = new TreeNode(3);
		boolean res = lzr.exist(tree, 10);
		System.out.print(res);
	}
}