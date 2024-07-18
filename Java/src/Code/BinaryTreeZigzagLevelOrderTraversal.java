package Code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BinaryTreeZigzagLevelOrderTraversal {
	List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int level = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> layer = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				layer.add(node.val);
			}
			if (level % 2 == 0) {
				Collections.reverse(layer);
			}
			res.add(layer);
			level++;
		}
		return res;
	}

	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal lzr = new BinaryTreeZigzagLevelOrderTraversal();
		Integer[] nodes = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = TreeNode.build(nodes);
		List<List<Integer>> res = lzr.zigzagLevelOrder(root);
		System.out.print(res);
	}
}