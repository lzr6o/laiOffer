package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LowestCommonAncestorIV {
	TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		return dfs(root, set);
	}

	TreeNode dfs(TreeNode root, Set<TreeNode> set) {
		if (root == null || set.contains(root)) {
			return root;
		}
		TreeNode left = dfs(root.left, set);
		TreeNode right = dfs(root.right, set);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}

	public static void main(String[] args) {
		LowestCommonAncestorIV lzr = new LowestCommonAncestorIV();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(12);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(3);
		tree.right.right = new TreeNode(14);
		List<TreeNode> nodes = new ArrayList<>();
		nodes.add(tree.left.left);
		nodes.add(tree.left.right);
		nodes.add(tree.right.right);
		TreeNode res = lzr.lowestCommonAncestor(tree, nodes);
		System.out.print(res.val);
	}
}