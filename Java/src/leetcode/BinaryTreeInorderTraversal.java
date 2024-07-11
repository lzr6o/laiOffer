package leetcode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeInorderTraversal {

	List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, res);
		return res;
	}

	void dfs(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		dfs(root.left, res);
		res.add(root.val);
		dfs(root.right, res);
	}
	
	public static void main(String[] args) {
		Integer[] arr = { 1, null, 2, 3 };
		TreeNode tree = TreeNode.build(arr);
		TreeNode.print(tree);
		BinaryTreeInorderTraversal lzr = new BinaryTreeInorderTraversal();
		List<Integer> res = lzr.inorderTraversal(tree);
		System.out.print(res);
	}
}