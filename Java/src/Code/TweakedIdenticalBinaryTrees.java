package Code;
class TweakedIdenticalBinaryTrees {
	static class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	public boolean isTweakedIdentical(TreeNode one, TreeNode two) {
		if (one == null && two == null) {
			return true;
		} else if (one == null || two == null) {
			return false;
		} else if (one.key != two.key) {
			return false;
		}
		return isTweakedIdentical(one.left, two.left) && isTweakedIdentical(one.right, two.right)
			   ||
			   isTweakedIdentical(one.left, two.right) && isTweakedIdentical(one.right, two.left);
	}
	
	public static void main(String args[]) {
		TweakedIdenticalBinaryTrees lzr = new TweakedIdenticalBinaryTrees();
		TreeNode one = new TreeNode(1);
		one.left = new TreeNode(2);
		one.right = new TreeNode(3);
		one.right.left = new TreeNode(4);
		TreeNode two = new TreeNode(1);
		two.left = new TreeNode(3);
		two.right = new TreeNode(2);
		two.left.left = new TreeNode(4);
		boolean result = lzr.isTweakedIdentical(one, two);
		System.out.print(result);
	}
}