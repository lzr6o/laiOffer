package leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TopViewOfBinaryTree {
	
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;

		TreeNode(int key) {
			this.key = key;
		}
	}

	class Pair {
		TreeNode node;
		int pos;
		
		Pair(TreeNode node, int pos) {
			this.node = node;
			this.pos = pos;
		}
	}
	
	List<Integer> topView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		Queue<Pair> q = new LinkedList<>();
		int L = 1, R = 0;
		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair pair = q.poll();
				TreeNode cur = pair.node;
				int pos = pair.pos;
				if (pos < L) {
					L = pos;
					res.add(0, cur.key);
				} else if (pos > R) {
					R = pos;
					res.add(cur.key);
				}
				if (cur.left != null) {
					q.offer(new Pair(cur.left, pos - 1));
				}
				if (cur.right != null) {
					q.offer(new Pair(cur.right, pos + 1));
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		TopViewOfBinaryTree lzr = new TopViewOfBinaryTree();
		TreeNode root = new TreeNode(1);
		List<Integer> res = lzr.topView(root);
		System.out.print(res);
	}
}