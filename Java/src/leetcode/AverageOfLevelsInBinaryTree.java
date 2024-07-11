package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class AverageOfLevelsInBinaryTree {

	List<Double> averageOfLevels(TreeNode root) {
		List<Double> average = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			int n = q.size();
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				TreeNode node = q.poll();
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				sum += node.val;
			}
			average.add(sum / n);
		}
		return average;
	}

	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree lzr = new AverageOfLevelsInBinaryTree();
		Integer[] nodes = { 3, 9, 20, null, null, 15, 7 };
		TreeNode root = TreeNode.build(nodes);
		List<Double> res = lzr.averageOfLevels(root);
		System.out.print(res);
	}
}