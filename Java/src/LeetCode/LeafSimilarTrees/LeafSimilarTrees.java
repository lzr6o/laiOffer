package LeetCode.LeafSimilarTrees;

import TreeNode.TreeNode;

class LeafSimilarTrees {
	boolean leafSimilar(TreeNode root1, TreeNode root2) {

	}

	public static void main(String[] args) {
		LeafSimilarTrees lzr = new LeafSimilarTrees();
		Integer[] nodes1 = { 3, 5, 1, 6, 2, 9, 8, null, null, 7, 4 };
		TreeNode root1 = TreeNode.build(nodes1);
		Integer[] nodes2 = { 3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8 };
		TreeNode root2 = TreeNode.build(nodes2);
		boolean res = lzr.leafSimilar(root1, root2);
		System.out.print(res);
	}
}