package LeetCode.ValidateBinarySearchTree;

import Tree.TreeNode;

class ValidateBinarySearchTree {
	boolean isValidBST(TreeNode root) {
		return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	boolean dfs(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree lzr = new ValidateBinarySearchTree();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(1);
		tree.right = new TreeNode(4);
		tree.right.left = new TreeNode(3);
		tree.right.right = new TreeNode(6);
		boolean res = lzr.isValidBST(tree);
		System.out.print(res);
	}
}