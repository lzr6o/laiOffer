package Code;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class PostOrderTraversalOfBinaryTreeIterative {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	List<Integer> postOrder(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> stack = new LinkedList<TreeNode>();
		stack.offerFirst(root);
		TreeNode prev = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peekFirst();
			if (prev == null || cur == prev.left || cur == prev.right) {
				if (cur.left != null) {
					stack.offerFirst(cur.left);
				} else if (cur.right != null) {
					stack.offerFirst(cur.right);
				} else {
					stack.pollFirst();
					result.add(cur.key);
				}
			} else if (prev == cur.right || prev == cur.left && cur.right == null) {
				stack.pollFirst();
				result.add(cur.key);
			} else {
				stack.offerFirst(cur.right);
			}
			prev = cur;
		}
		return result;
	}
	
	public static void main(String args[]) {
		
	}
}