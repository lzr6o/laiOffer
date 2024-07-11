package leetcode;

class ConvertSortedArrayToBinarySearchTree {

	TreeNode sortedArrayToBST(int[] nums) {
		return dfs(nums, 0, nums.length - 1);
	}

	TreeNode dfs(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(nums, left, mid - 1);
		root.right = dfs(nums, mid + 1, right);
		return root;
	}

	public static void main(String[] args) {
		ConvertSortedArrayToBinarySearchTree lzr = new ConvertSortedArrayToBinarySearchTree();
		int[] nums = { -10, -3, 0, 5, 9 };
		TreeNode root = lzr.sortedArrayToBST(nums);
		TreeNode.print(root);
	}
}