package leetcode;

class IdenticalBinaryTree {

	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	boolean isIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		return isIdentical(one.left, two.left) && isIdentical(one.right, two.right);
	}
	
	public static void main(String[] args) {
		IdenticalBinaryTree lzr = new IdenticalBinaryTree();
		
	}
}
