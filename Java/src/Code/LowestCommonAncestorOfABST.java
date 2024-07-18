package Code;

class LowestCommonAncestorOfABST {
	TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else {
				return root;
			}
		}
	}

	public static void main(String[] args) {
		LowestCommonAncestorOfABST lzr = new LowestCommonAncestorOfABST();
	}
}