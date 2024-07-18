package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DeleteNodesAndReturnForest {
	List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> res = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		for (int node : to_delete) {
			set.add(node);
		}
		dfs(root, set, true, res);
		return res;
	}

	TreeNode dfs(TreeNode root, Set<Integer> set, boolean isRoot, List<TreeNode> res) {
		if (root == null) {
			return null;
		}
		boolean deleted = set.contains(root.val);
		if (isRoot && !deleted) {
			res.add(root);
		}
		root.left = dfs(root.left, set, deleted, res);
		root.right = dfs(root.right, set, deleted, res);
		return deleted ? null : root;
	}

	public static void main(String[] args) {
		DeleteNodesAndReturnForest lzr = new DeleteNodesAndReturnForest();
		Integer[] nodes = { 1, 2, 3, 4, 5, 6, 7 };
		TreeNode root = TreeNode.build(nodes);
		System.out.print("Before :" + "\n");
		TreeNode.print(root);
		int[] to_delete = { 3, 5 };
		List<TreeNode> res = lzr.delNodes(root, to_delete);
		System.out.print("After :" + "\n");
		TreeNode.print(root);
		for (TreeNode node : res) {
			System.out.print(node.val + " ");
		}
	}
}