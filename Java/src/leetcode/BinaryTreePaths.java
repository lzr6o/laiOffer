package leetcode;

import java.util.ArrayList;
import java.util.List;

class BinaryTreePaths {
	List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		dfs(root, "", paths);
		return paths;
	}

	void dfs(TreeNode root, String path, List<String> paths) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			path += root.val;
			paths.add(path);
			return;
		}
		path += root.val + "->";
		dfs(root.left, path, paths);
		dfs(root.right, path, paths);
	}
	
	public static void main(String[] args) {
		BinaryTreePaths lzr = new BinaryTreePaths();
		Integer[] nodes = { 1, 2, 3, null, 5 };
		TreeNode root = TreeNode.build(nodes);
		TreeNode.print(root);
		List<String> res = lzr.binaryTreePaths(root);
		System.out.print(res);
	}
}