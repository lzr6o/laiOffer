package Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeLevelOrderTraversalII {
	List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> layer = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				layer.add(cur.val);
				if (cur.left != null) {
					q.add(cur.left);
				}
				if (cur.right != null) {
					q.add(cur.right);
				}
			}
			res.add(0, layer);
		}
		return res;
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII lzr = new BinaryTreeLevelOrderTraversalII();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		List<List<Integer>> res = lzr.levelOrderBottom(root);
		System.out.print(res);
	}
}