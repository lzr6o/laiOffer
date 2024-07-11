package leetcode;
import java.util.LinkedList;
import java.util.Queue;

class LevelOrderReconstructCompleteBinaryTree {

	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int key) {
			this.key = key;
		}
	}

	TreeNode construct(int[] level) {
		Queue<TreeNode> nodes = new LinkedList<>();
		Queue<TreeNode> next = new LinkedList<>();
		for (int num : level) {
			nodes.offer(new TreeNode(num));
		}
		TreeNode root = nodes.poll();
		next.offer(root);
		int num = 1;
		while (!nodes.isEmpty()) {
			for (int i = 0; i < num; i++) {
				TreeNode cur = next.poll();
				cur.left = nodes.poll();
				cur.right = nodes.poll();
				next.add(cur.left);
				next.add(cur.right);
			}
			num *= 2;
		}
		return root;
	}

	public static void main(String[] args) {
		

	}

}
