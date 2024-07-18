package Code;

class LowestCommonAncestor {
	TreeNode lowestCommonAncestor(TreeNode root, TreeNode one, TreeNode two) {
		if (root == null) {
			return root;
		}
		if (root == one || root == two) {
			return root;
		}
		TreeNode ll = lowestCommonAncestor(root.left, one, two);
		TreeNode lr = lowestCommonAncestor(root.right, one, two);
		if (ll != null && lr != null) {
			return root;
		}
		return ll == null ? lr : ll;
	}

	public static void main(String[] args) {
		LowestCommonAncestor lzr = new LowestCommonAncestor();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(12);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(3);
		tree.right.right = new TreeNode(14);
		TreeNode res = lzr.lowestCommonAncestor(tree, tree.left.left, tree.left.right);
		System.out.print(res.val);
	}
}