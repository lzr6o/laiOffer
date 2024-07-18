package Code;

import java.util.HashMap;
import java.util.Map;

class PathSumIII {
	int cnt;
	Map<Long, Integer> map;

	int pathSum(TreeNode root, int targetSum) {
		map = new HashMap<>();
		cnt = 0;
		dfs(root, 0, targetSum);
		return cnt;
	}

	void dfs(TreeNode root, long preSum, int tarSum) {
		if (root == null) {
			return;
		}
		preSum += root.val;
		if (map.containsKey(preSum - tarSum)) {
			cnt += map.get(preSum - tarSum);
		}
		if (preSum == tarSum) {
			cnt++;
		}
		map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		dfs(root.left, preSum, tarSum);
		dfs(root.right, preSum, tarSum);
		map.put(preSum, map.get(preSum) - 1);
	}

	public static void main(String[] args) {
		PathSumIII lzr = new PathSumIII();
		Integer[] nodes = { 10, 5, -3, 3, 2, null, 11, 3, -2, null, 1 };
		TreeNode tree = TreeNode.build(nodes);
		TreeNode.print(tree);
		System.out.print("\n");
		int targetSum = 8;
		int res = lzr.pathSum(tree, targetSum);
		System.out.print(res);
	}
}