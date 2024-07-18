package Code;

class MergeTwoBinaryTrees {
	TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null) {
			return null;
		}
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		TreeNode node = new TreeNode(root1.val + root2.val);
		node.left = mergeTrees(root1.left, root2.left);
		node.right = mergeTrees(root1.right, root2.right);
		return node;
	}

	public static void main(String[] args) {
		MergeTwoBinaryTrees lzr = new MergeTwoBinaryTrees();
		Integer[] nodes1 = { 1, 3, 2, 5 };
		TreeNode root1 = TreeNode.build(nodes1);
		TreeNode.print(root1);
		System.out.print("\n");
		Integer[] nodes2 = { 2, 1, 3, null, 4, null, 7 };
		TreeNode root2 = TreeNode.build(nodes2);
		TreeNode.print(root2);
		System.out.print("\n");
		TreeNode res = lzr.mergeTrees(root1, root2);
		TreeNode.print(res);
	}
}