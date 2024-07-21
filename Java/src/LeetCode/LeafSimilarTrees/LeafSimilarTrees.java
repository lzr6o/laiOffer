package LeetCode.LeafSimilarTrees;

import java.util.ArrayList;
import java.util.List;
import TreeNode.TreeNode;

class LeafSimilarTrees {
	boolean leafSimilar(TreeNode root1, TreeNode root2) {
		List<Integer> leaves1 = new ArrayList<>(), leaves2 = new ArrayList<>();
		dfs(root1, leaves1);
		dfs(root2, leaves2);
		return leaves1.equals(leaves2);
	}

	void dfs(TreeNode root, List<Integer> leaves) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			leaves.add(root.val);
			return;
		}
		dfs(root.left, leaves);
		dfs(root.right, leaves);
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