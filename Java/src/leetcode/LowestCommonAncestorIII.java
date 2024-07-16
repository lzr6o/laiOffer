package leetcode;

class LowestCommonAncestorIII {
	TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		boolean[] valid = new boolean[1];
		TreeNode res = helper(root, one, two, valid);
		if (valid[0]) {
			return res;
		}
		return null;
	}

	TreeNode helper(TreeNode root, TreeNode one, TreeNode two, boolean[] valid) {
		if (root == null) {
			return null;
		}
		TreeNode left = helper(root.left, one, two, valid);
		TreeNode right = helper(root.right, one, two, valid);
		if (left != null && right != null) {
			valid[0] = true;
			return root;
		} else if (root == one || root == two) {
			if (left != null || right != null) {
				valid[0] = true;
			}
			return root;
		}
		return left == null ? right : left;
	}

	public static void main(String[] args) {
		LowestCommonAncestorIII lzr = new LowestCommonAncestorIII();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(12);
		tree.left.left = new TreeNode(2);
		tree.left.right = new TreeNode(3);
		tree.right.right = new TreeNode(14);
		TreeNode ancestor = lzr.lowestCommonAncestor(tree, tree.left.left, null);
		System.out.print(ancestor.val);
	}
}