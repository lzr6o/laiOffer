package leetcode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class PreOrderTraversalOfBinaryTreeIterative {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	List<Integer> preOrder(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();
		if (root == null) {
			return preorder;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pollFirst();
			if (cur.right != null) {
				stack.offerFirst(cur.right);
			}
			if (cur.left != null) {
				stack.offerFirst(cur.left);
			}
			preorder.add(cur.key);
		}
		return preorder;
	}
	
	public static void main(String args[]) {
		
	}
}