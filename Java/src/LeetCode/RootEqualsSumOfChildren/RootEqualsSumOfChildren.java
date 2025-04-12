package LeetCode.RootEqualsSumOfChildren;

import Tree.TreeNode;

class RootEqualsSumOfChildren {
	boolean checkTree(TreeNode root) {
		return root.val == root.left.val + root.right.val;
	}

	public static void main(String[] args) {
		RootEqualsSumOfChildren lzr = new RootEqualsSumOfChildren();
		Integer[] nodes = { 10, 4, 6 };
		TreeNode root = TreeNode.build(nodes);
		boolean res = lzr.checkTree(root);
		System.out.print(res);
	}
}