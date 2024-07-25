package LeetCode.面试题.SuccessorLCCI;

class SuccessorLCCI {
	TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}
		if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		}
		TreeNode ans = inorderSuccessor(root.left, p);
		return ans == null ? root : ans;
	}

	public static void main(String[] args) {
		SuccessorLCCI lzr = new SuccessorLCCI();
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		TreeNode p = root.left;
		TreeNode next = lzr.inorderSuccessor(root, p);
		System.out.print(next.val);
	}
}