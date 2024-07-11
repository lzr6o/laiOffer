package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CourseScheduleII {

	int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> preReq = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			preReq.put(i, new ArrayList<>());
		}
		for (int[] pre : prerequisites) {
			preReq.get(pre[0]).add(pre[1]);
		}
		List<Integer> order = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();
		Set<Integer> cycle = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(preReq, visited, cycle, i, order)) {
				return new int[] {};
			}
		}
		int[] res = new int[order.size()];
		for (int i = 0; i < order.size(); i++) {
			res[i] = order.get(i);
		}
		return res;
	}

	boolean dfs(Map<Integer, List<Integer>> preReq, Set<Integer> visited, Set<Integer> cycle, int crs, List<Integer> order) {
		if (cycle.contains(crs)) {
			return false;
		}
		if (visited.contains(crs)) {
			return true;
		}
		cycle.add(crs);
		for (int pre : preReq.get(crs)) {
			if (!dfs(preReq, visited, cycle, pre, order)) {
				return false;
			}
		}
		cycle.remove(crs);
		visited.add(crs);
		order.add(crs);
		return true;
	}

	public static void main(String[] args) {
		CourseScheduleII lzr = new CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] res = lzr.findOrder(numCourses, prerequisites);
		System.out.print(Arrays.toString(res));
	}
}