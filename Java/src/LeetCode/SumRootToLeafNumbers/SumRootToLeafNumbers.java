package LeetCode.SumRootToLeafNumbers;

import TreeNode.TreeNode;

class SumRootToLeafNumbers {
	int sum = 0;

	int sumNumbers(TreeNode root) {
		dfs(root, 0);
		return sum;
	}

	void dfs(TreeNode root, int cur) {
		if (root == null) {
			return;
		}
		cur = cur * 10 + root.val;
		if (root.left == null && root.right == null) {
			sum += cur;
			return;
		}
		dfs(root.left, cur);
		dfs(root.right, cur);
	}

	public static void main(String[] args) {
		SumRootToLeafNumbers lzr = new SumRootToLeafNumbers();
		Integer[] nodes = { 4, 9, 0, 5, 1 };
		TreeNode root = TreeNode.build(nodes);
		TreeNode.print(root);
		int res = lzr.sumNumbers(root);
		System.out.print(res);
	}
}