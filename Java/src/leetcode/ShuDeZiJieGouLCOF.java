package leetcode;
class ShuDeZiJieGouLCOF {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == null || B == null) {
			return false;
		}
		return isSubStructure(A.left, B) || isSubStructure(A.right, B) || valid(A, B);
	}
	
	boolean valid(TreeNode one, TreeNode two) {
		if (two == null) {
			return true;
        } else if (one == null) {
			return false;
		} else if (one.val == two.val) {
			return valid(one.left, two.left) && valid(one.right, two.right);
		}
		return false;
	}
	
	public static void main(String[] args) {
		ShuDeZiJieGouLCOF lzr = new ShuDeZiJieGouLCOF();
		TreeNode A = new TreeNode(3);
		A.left = new TreeNode(4);
		A.right = new TreeNode(5);
		A.left.left = new TreeNode(1);
		A.left.right = new TreeNode(2);
		TreeNode B = new TreeNode(4);
		B.left = new TreeNode(1);
		boolean res = lzr.isSubStructure(A, B);
		System.out.print(res);
	}
}