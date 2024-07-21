package LeetCode.SameTree;

import TreeNode.TreeNode;

class SameTree {
	boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null || p.val != q.val) {
			return false;
		}
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public static void main(String[] args) {
		SameTree lzr = new SameTree();
		Integer[] pNodes = { 1, 2, 3 };
		TreeNode p = TreeNode.build(pNodes);
		Integer[] qNodes = { 1, 2, 3 };
		TreeNode q = TreeNode.build(qNodes);
		boolean res = lzr.isSameTree(p, q);
		System.out.print(res);
	}
}