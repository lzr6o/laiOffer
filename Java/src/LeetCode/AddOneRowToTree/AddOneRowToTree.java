package LeetCode.AddOneRowToTree;

import TreeNode.TreeNode;

class AddOneRowToTree {
	TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			return new TreeNode(val, root, null);
		}
		dfs(root, val, 1, depth);
		return root;
	}

	void dfs(TreeNode node, int val, int d, int depth) {
		if (node == null || d >= depth) {
			return;
		}
		if (d == depth - 1) {
			node.left = new TreeNode(val, node.left, null);
			node.right = new TreeNode(val, null, node.right);
			return;
		}
		dfs(node.left, val, d + 1, depth);
		dfs(node.right, val, d + 1, depth);
	}

	public static void main(String[] args) {
		AddOneRowToTree lzr = new AddOneRowToTree();
		Integer[] nodes = { 4, 2, 6, 3, 1, 5 };
		TreeNode root = TreeNode.build(nodes);
		TreeNode.print(root);
		System.out.print("\n");
		int val = 1;
		int depth = 1;
		TreeNode res = lzr.addOneRow(root, val, depth);
		TreeNode.print(res);
	}
}