package leetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LowestCommonAncestorIV {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	TreeNode lowestCommonAncestor(TreeNode root, List<TreeNode> nodes) {
		Set<TreeNode> set = new HashSet<>(nodes);
		return helper(root, set);
	}
	
	TreeNode helper(TreeNode root, Set<TreeNode> set) {
		if (root == null || set.contains(root)) {
			return root;
		}
		TreeNode left = helper(root.left, set);
		TreeNode right = helper(root.right, set);
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
		TreeNode result = lzr.lowestCommonAncestor(tree, nodes);
		System.out.print(result.key);
	}
}