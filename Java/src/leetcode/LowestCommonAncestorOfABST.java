package leetcode;
class LowestCommonAncestorOfABST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while (true) {
			if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else {
				return root;
			}
		}
	}
	
	public static void main(String[] args) {
		
	}
}
