package leetcode;
class ReconstructBinarySearchTreeWithPostOrderTraversal {
	class TreeNode {
		int key;
		TreeNode left;
		TreeNode right;
		TreeNode(int key) {
			this.key = key;
		}
	}
	
	TreeNode reconstruct(int[] post) {
		int[] index = new int[] { post.length - 1 };
		return helper(post, index, Integer.MIN_VALUE);
	}
	
	TreeNode helper(int[] post, int[] index, int min) {
		if (index[0] < 0 || post[index[0]] <= min) {
			return null;
		}
		TreeNode root = new TreeNode(post[index[0]--]);
		root.right = helper(post, index, root.key);
		root.left = helper(post, index, min);
		return root;
	}
	
	public static void main(String[] args) {
		ReconstructBinarySearchTreeWithPostOrderTraversal lzr = new ReconstructBinarySearchTreeWithPostOrderTraversal();
		int[] post = { 1, 4, 3, 11, 8, 5 };
		TreeNode tree = lzr.reconstruct(post);
	}
}