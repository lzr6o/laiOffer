package leetcode;

class InsertInBinarySearchTree {

	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	void helper(TreeNode root, int target) {
		if (target == root.key) {
			return;
		} else if (target < root.key) {
			if (root.left == null) {
				root.left = new TreeNode(target);
			} else {
				helper(root.left, target);
			}
		} else {
			if (root.right == null) {
				root.right = new TreeNode(target);
			} else {
				helper(root.right, target);
			}
		}
	}
	
	TreeNode insert(TreeNode root, int key) {
		if (root == null) {
			return new TreeNode(key);
		}
		helper(root, key);
		return root;
	}
	
	public static void main(String args[]) {
		
	}
}