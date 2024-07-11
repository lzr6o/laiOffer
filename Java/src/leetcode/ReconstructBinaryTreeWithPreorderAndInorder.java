package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ReconstructBinaryTreeWithPreOrderAndInOrder {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	TreeNode reconstruct(int[] in, int[] pre) {
		int[] preIndex = new int[] { 0 };
		int[] inIndex = new int[] { 0 };
		return helper(pre, in, preIndex, inIndex, Integer.MAX_VALUE);
	}
	
	TreeNode helper(int[] pre, int[] in, int[] preIndex, int[] inIndex, int target) {
		if (inIndex[0] >= in.length || in[inIndex[0]] == target) {
			return null;
		}
		TreeNode root = new TreeNode(pre[preIndex[0]]);
		preIndex[0]++;
		root.left = helper(pre, in, preIndex, inIndex, root.key);
		inIndex[0]++;
		root.right = helper(pre, in, preIndex, inIndex, target);
		return root;
	}
	
	void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> curLayer = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				curLayer.add(cur.key);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			System.out.print(curLayer + "\n");
		}
	}
	
	public static void main(String[] args) {
		ReconstructBinaryTreeWithPreOrderAndInOrder lzr = new ReconstructBinaryTreeWithPreOrderAndInOrder();
		int[] in = { 1, 3, 4, 5, 8, 11 };
		int[] pre = { 5, 3, 1, 4, 8, 11 };
		TreeNode tree = lzr.reconstruct(in, pre);
		lzr.printTree(tree);
	}
}