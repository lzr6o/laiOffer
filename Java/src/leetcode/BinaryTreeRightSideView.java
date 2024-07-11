package leetcode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeRightSideView {
	List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, 1, res);
		return res;
	}

	void dfs(TreeNode root, int level, List<Integer> res) {
		if (root == null) {
			return;
		}
		if (level > res.size()) {
			res.add(root.val);
		}
		dfs(root.right, level + 1, res);
		dfs(root.left, level + 1, res);
	}
	
	public static void main(String[] args) {
		BinaryTreeRightSideView lzr = new BinaryTreeRightSideView();

	}
}