package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ReconstructBinaryTreeWithPostOrderAndInOrder {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int key) {
			this.key = key;
		}
	}

	TreeNode reconstruct(int[] in, int[] post) {
		int[] postIndex = new int[] { post.length - 1 };
		int[] inIndex = new int[] { 0 };
		return helper(post, in, postIndex, inIndex, Integer.MAX_VALUE);
	}
	
	TreeNode helper(int[] post, int[] in, int[] postIndex, int[] inIndex, int target) {
		if (inIndex[0] >= in.length || in[inIndex[0]] == target || postIndex[0] >= post.length) {
			return null;
		}
		TreeNode root = new TreeNode(post[postIndex[0]]);
		inIndex[0]++;
		root.left = helper(post, in, postIndex, inIndex, root.key);
		postIndex[0]--;
		root.right = helper(post, in, postIndex, inIndex, target);
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
		ReconstructBinaryTreeWithPostOrderAndInOrder lzr = new ReconstructBinaryTreeWithPostOrderAndInOrder();
		int[] in = { 1, 3, 4, 5, 8, 11 };
		int[] post = { 1, 4, 3, 11, 8, 5 };
		TreeNode tree = lzr.reconstruct(in, post);
		lzr.printTree(tree);
	}
}