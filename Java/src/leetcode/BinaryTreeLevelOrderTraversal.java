package leetcode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeLevelOrderTraversal {
	List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(root, 0, res);
		return res;
	}

	void dfs(TreeNode root, int level, List<List<Integer>> res) {
		if (root == null) {
			return;
		}
		if (level == res.size()) {
			res.add(new ArrayList<>());
		}
		res.get(level).add(root.val);
		dfs(root.left, level + 1, res);
		dfs(root.right, level + 1, res);
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal lzr = new BinaryTreeLevelOrderTraversal();

	}
}
