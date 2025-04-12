package LeetCode.FlipEquivalentBinaryTrees;

import Tree.TreeNode;

class FlipEquivalentBinaryTrees {
	boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		} else if (root1.val != root2.val) {
			return false;
		}
		return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
				|| flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
	}

	public static void main(String args[]) {
		FlipEquivalentBinaryTrees lzr = new FlipEquivalentBinaryTrees();
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.right.left = new TreeNode(4);
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		root2.left.left = new TreeNode(4);
		boolean result = lzr.flipEquiv(root1, root2);
		System.out.print(result);
	}
}