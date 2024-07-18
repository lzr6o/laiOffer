package Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ConvertBSTToGreaterTree {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	TreeNode convertBST(TreeNode root) {
		int[] sum = new int[1];
		dfs(root, sum);
		return root;
	}
	
	void dfs(TreeNode root, int[] sum) {
		if (root == null) {
			return;
		}
		dfs(root.right, sum);
		sum[0] += root.val;
		root.val = sum[0];
		dfs(root.left, sum);
	}
	
	public TreeNode buildTree(Integer[] nodes) {
		TreeNode root = new TreeNode(nodes[0]);
		int count = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		TreeNode cur = null;
		for (int i = 1; i < nodes.length; i++) {
			TreeNode node = nodes[i] != null ? new TreeNode(nodes[i]) : null;
			if (count == 0) {
				cur = queue.poll();
			}
			if (count == 0) {
				count++;
				cur.left = node;
			} else {
				count = 0;
				cur.right = node;
			}
			if (nodes[i] != null) {
				queue.offer(node);
			}
		}
		return root;
	}

	public void printTree(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<String> curLayer = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur != null) {
					curLayer.add(Integer.toString(cur.val));
				} else {
					curLayer.add("#");
					continue;
				}
				if (cur.left != null) {
					queue.offer(cur.left);
				} else {
					queue.offer(null);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				} else {
					queue.offer(null);
				}
			}
			for (String node : curLayer) {
				System.out.print(node + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args) {
		ConvertBSTToGreaterTree lzr = new ConvertBSTToGreaterTree();
		Integer[] nodes = { 4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8 };
		TreeNode tree = lzr.buildTree(nodes);
		lzr.printTree(tree);
		System.out.print("\n");
		TreeNode newTree = lzr.convertBST(tree);
		lzr.printTree(newTree);
	}
}