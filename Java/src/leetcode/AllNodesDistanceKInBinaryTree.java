package leetcode;

import java.util.ArrayList;
import java.util.List;

class AllNodesDistanceKInBinaryTree {
	
	List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		TreeNode[] prev = new TreeNode[1];
		List<Integer> res = new ArrayList<>();
		dfs(root, target, k, prev, res);
		return res;
	}

	TreeNode[] dfs(TreeNode root, TreeNode target, int k, TreeNode[] prev, List<Integer> res) {
		if (root == null) {
			return null;
		}
		if (k == 0) {
			res.add(root.val);
		}
		if (root == target) {
			while (root != null) {
				if (root.left != null) {
					dfs(root.left, target, k - 1, prev, res);
				}
				if (root.right != null) {
					dfs(root.right, target, k - 1, prev, res);
				}
			}
		}
		prev[0] = root;
		dfs(root.left, target, k, prev, res);
		dfs(root.right, target, k, prev, res);
		return prev;
	}

	public static void main(String[] args) {
		AllNodesDistanceKInBinaryTree lzr = new AllNodesDistanceKInBinaryTree();
		Integer[] nodes = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
		TreeNode root = TreeNode.build(nodes);
		TreeNode target = root.left;
		int k = 2;
		List<Integer> res = lzr.distanceK(root, target, k);
		System.out.print(res);
	}
}