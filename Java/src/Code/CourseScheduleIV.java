package Code;

import java.util.ArrayList;
import java.util.List;

class CourseScheduleIV {

	List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
		boolean[][] dp = new boolean[numCourses][numCourses];
		for (int[] pre : prerequisites) {
			dp[pre[0]][pre[1]] = true;
		}
		for (int k = 0; k < numCourses; k++) {
			for (int i = 0; i < numCourses; i++) {
				for (int j = 0; j < numCourses; j++) {
					dp[i][j] = dp[i][j] || dp[i][k] && dp[k][j];
				}
			}
		}
		List<Boolean> ans = new ArrayList<>();
		for (int[] qry : queries) {
			ans.add(dp[qry[0]][qry[1]]);
		}
		return ans;
	}

	public static void main(String[] args) {
		CourseScheduleIV lzr = new CourseScheduleIV();
		int numCourses = 3;
		int[][] prerequisites = { { 1, 0 }, { 2, 1 } };
		int[][] queries = { { 1, 0 }, { 1, 2 } };
		List<Boolean> res = lzr.checkIfPrerequisite(numCourses, prerequisites, queries);
		System.out.print(res);
	}
}