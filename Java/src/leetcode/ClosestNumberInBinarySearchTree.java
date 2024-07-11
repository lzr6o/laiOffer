package leetcode;

class ClosestNumberInBinarySearchTree {

	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	int closest(TreeNode root, int target) {
		int res = root.key;
		while (root != null) {
			if (root.key == target) {
				return root.key;
			} else {
				if (Math.abs(root.key - target) < Math.abs(res - target)) {
					res = root.key;
				}
				if (root.key < target) {
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