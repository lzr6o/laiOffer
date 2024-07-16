package leetcode;

import java.util.ArrayList;
import java.util.List;

class PathSumII {
	List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<Integer> cur = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(root, targetSum, cur, res);
		return res;
	}

	void dfs(TreeNode root, int targetSum, List<Integer> cur, List<List<Integer>> res) {
		targetSum -= root.val;
		cur.add(root.val);
		if (root.left == null && root.right == null) {
			if (targetSum == 0) {
				res.add(new ArrayList<Integer>(cur));
			}
		} else {
			if (root.left != null) {
				dfs(root.left, targetSum, cur, res);
			}
			if (root.right != null) {
				dfs(root.right, targetSum, cur, res);
			}
		}
		cur.remove(cur.size() - 1);
	}

	public static void main(String[] args) {
		PathSumII lzr = new PathSumII();
		Integer[] nodes = { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 };
		TreeNode tree = TreeNode.build(nodes);
		int targetSum = 22;
		List<List<Integer>> res = lzr.pathSum(tree, targetSum);
		System.out.print(res);
	}
}