package LeetCode.SymmetricTree;

import Tree.TreeNode;

class SymmetricTree {
	boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return dfs(root.left, root.right);
	}

	boolean dfs(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else if (root1.val != root2.val) {
			return false;
		}
		return dfs(root1.left, root2.right) && dfs(root1.right, root2.left);
	}

	public static void main(String[] args) {
		SymmetricTree lzr = new SymmetricTree();
		Integer[] level = { 5, 3, 1, 4, };
		TreeNode tree = TreeNode.build(level);
		TreeNode.print(tree);
		boolean res = lzr.isSymmetric(tree);
		System.out.print(res);
	}
}