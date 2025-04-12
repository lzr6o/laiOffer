package LeetCode.SumOfRootToLeafBinaryNumbers;

import Tree.TreeNode;

class SumOfRootToLeafBinaryNumbers {
	int sumRootToLeaf(TreeNode root) {
		return dfs(root, 0);
	}

	int dfs(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		sum = sum * 2 + root.val;
		if (root.left == null && root.right == null) {	
			return sum;
		}
		return dfs(root.left, sum) + dfs(root.right, sum);
	}

	public static void main(String[] args) {
		SumOfRootToLeafBinaryNumbers lzr = new SumOfRootToLeafBinaryNumbers();
		Integer[] nodes = { 1, 0, 1, 0, 1, 0, 1 };
		TreeNode root = TreeNode.build(nodes);
		int res = lzr.sumRootToLeaf(root);
		System.out.print(res);
	}
}