package leetcode;

import java.util.ArrayList;
import java.util.List;

class BoundaryOfBinaryTree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	List<Integer> boundaryOfBinaryTree(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root.left == null && root.right == null) {
			res.add(root.val);
			return res;
		}
		res.add(root.val);
		dfsL(root.left, res);
		dfsM(root, res);
		dfsR(root.right, res);
		return res;
	}

	void dfsL(TreeNode root, List<Integer> res) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		res.add(root.val);
		if (root.left != null) {
			dfsL(root.left, res);
		} else {
			dfsL(root.right, res);
		}
	}

	void dfsM(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			res.add(root.val);
		}
		dfsM(root.left, res);
		dfsM(root.right, res);
	}

	void dfsR(TreeNode root, List<Integer> res) {
		if (root == null || (root.left == null && root.right == null)) {
			return;
		}
		if (root.right != null) {
			dfsR(root.right, res);
		} else {
			dfsR(root.left, res);
		}
		res.add(root.val);
	}

	public static void main(String[] args) {
		BoundaryOfBinaryTree lzr = new BoundaryOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(8);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(10);
		List<Integer> res = lzr.boundaryOfBinaryTree(root);
		System.out.print(res);
	}
}