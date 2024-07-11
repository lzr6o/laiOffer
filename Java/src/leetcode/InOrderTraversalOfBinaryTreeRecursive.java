package leetcode;

import java.util.ArrayList;
import java.util.List;

class InOrderTraversalOfBinaryTreeRecursive {

	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	List<Integer> inOrder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		helper(root, res);
		return res;
	}
	
	void helper(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		helper(root.left, res);
		res.add(root.key);
		helper(root.right, res);
	}
	
	TreeNode constructTree(int[] arr, TreeNode root, int i) {
		if (i < arr.length) {
			TreeNode node = new TreeNode(arr[i]);
			root = node;
			root.left = constructTree(arr, root.left, 2 * i + 1);
			root.right = constructTree(arr, root.right, 2 * i + 2);
		}
		return root;
	}

	public static void main(String[] args) {
		InOrderTraversalOfBinaryTreeRecursive lzr = new InOrderTraversalOfBinaryTreeRecursive();
		int[] arr = { 5, 3, 8, 1, 4, 11 };
		TreeNode root = new TreeNode(0);
		TreeNode tree = lzr.constructTree(arr, root, 0);
		List<Integer> res = lzr.inOrder(tree);
		System.out.print(res);
	}
}