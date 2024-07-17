package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CourseSchedule {
	boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> preReq = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			preReq.put(i, new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			preReq.get(pre[0]).add(pre[1]);
		}
		Set<Integer> visited = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(preReq, visited, i)) {
				return false;
			}
		}
		return true;
	}

	boolean dfs(Map<Integer, List<Integer>> preReq, Set<Integer> visited, int crs) {
		if (visited.contains(crs)) {
			return false;
		}
		if (preReq.get(crs) == null) {
			return true;
		}
		visited.add(crs);
		for (int pre : preReq.get(crs)) {
			if (!dfs(preReq, visited, pre)) {
				return false;
			}
		}
		visited.remove(crs);
		preReq.put(crs, null);
		return true;
	}

	public static void main(String[] args) {
		CourseSchedule lzr = new CourseSchedule();
		int numCourses = 5;
		int[][] prerequisites = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 } };
		boolean res = lzr.canFinish(numCourses, prerequisites);
		System.out.print(res);
	}
}