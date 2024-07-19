package LeetCode.Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Triangle {
	int minimumTotal(List<List<Integer>> triangle) {
		int min = Integer.MAX_VALUE;
		int[] dp = new int[triangle.size()];
		dp[0] = triangle.get(0).get(0);
		if (triangle.size() == 1) {
			return dp[0];
		}
		for (int i = 1; i < triangle.size(); i++) {
			min = Integer.MAX_VALUE;
			for (int j = i; j >= 0; j--) {
				if (j == i) {
					dp[j] = dp[j - 1] + triangle.get(i).get(j);
				} else if (j == 0) {
					dp[j] = dp[j] + triangle.get(i).get(j);
				} else {
					dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
				}
				min = Math.min(min, dp[j]);
			}
		}
		return min;
	}

	public static void main(String[] args) {
		Triangle lzr = new Triangle();
		List<List<Integer>> triangle = new ArrayList<>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		int res = lzr.minimumTotal(triangle);
		System.out.print(res);
	}
}