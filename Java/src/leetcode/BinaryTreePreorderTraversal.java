package leetcode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePreorderTraversal {
	
	List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		preOrder(root, res);
		return res;
	}

	void preOrder(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		preOrder(root.left, res);
		preOrder(root.right, res);
	}

	public static void main(String[] args) {
		BinaryTreePreorderTraversal lzr = new BinaryTreePreorderTraversal();
		Integer[] nodes = { 1, null, 2, 3 };
		TreeNode root = TreeNode.build(nodes);
		List<Integer> res = lzr.preorderTraversal(root);
		System.out.print(res);
	}
}