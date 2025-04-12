package Code;

import TreeNode.TreeNode;

class BalancedBinaryTree {
	boolean isBalanced(TreeNode root) {
		boolean[] res = new boolean[1];
		res[0] = true;
		dfs(root, res);
		return res[0];
	}

	int dfs(TreeNode root, boolean[] res) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left, res);
		int right = dfs(root.right, res);
		if (Math.abs(left - right) > 1) {
			res[0] = false;
		}
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {

	}
}
