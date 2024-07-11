package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GetKeysInBinaryTreeLayerByLayer {
	List<List<Integer>> layerByLayer(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> curLayer = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				curLayer.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(curLayer);
		}
		return res;
	}

	public static void main(String args[]) {
		GetKeysInBinaryTreeLayerByLayer lzr = new GetKeysInBinaryTreeLayerByLayer();
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(3);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(4);
		tree.right.right = new TreeNode(11);
		List<List<Integer>> result = lzr.layerByLayer(tree);
		System.out.print(result);
	}
}