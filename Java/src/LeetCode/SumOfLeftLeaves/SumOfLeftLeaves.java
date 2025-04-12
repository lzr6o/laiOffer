package LeetCode.SumOfLeftLeaves;

import Tree.TreeNode;

class SumOfLeftLeaves {
	int sumOfLeftLeaves(TreeNode root) {
		return dfs(root, false, 0);
	}

	int dfs(TreeNode root, boolean isLeft, int sum) {
		if (root == null) {
			return 0;
		}
		if (isLeft && root.left == null && root.right == null) {
			sum += root.val;
			return sum;
		}
		return dfs(root.left, true, sum) + dfs(root.right, false, sum);
	}

	public static void main(String[] args) {
		SumOfLeftLeaves lzr = new SumOfLeftLeaves();
		Integer[] nodes = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = TreeNode.build(nodes);
		TreeNode.print(root);
		int res = lzr.sumOfLeftLeaves(root);
		System.out.print(res);
	}
}