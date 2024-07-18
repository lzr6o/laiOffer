package Code;

class ClosestNumberInBinarySearchTree {
	int closest(TreeNode root, int target) {
		int res = root.val;
		while (root != null) {
			if (root.val == target) {
				return root.val;
			} else {
				if (Math.abs(root.val - target) < Math.abs(res - target)) {
					res = root.val;
				}
				if (root.val < target) {
					root = root.right;
				} else {
					root = root.left;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ClosestNumberInBinarySearchTree lzr = new ClosestNumberInBinarySearchTree();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(11);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(14);
		int res = lzr.closest(tree, 10);
		System.out.print(res);
	}
}