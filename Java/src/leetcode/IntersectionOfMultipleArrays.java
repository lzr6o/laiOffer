package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class IntersectionOfMultipleArrays {

	List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();
		for (int[] arr : nums) {
			for (int num : arr) {
				map.put(num, map.getOrDefault(num, 0) + 1);
			}
		}
		List<Integer> res = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == nums.length) {
				res.add(key);
			}
		}
		Collections.sort(res);
		return res;
    }
	
	public static void main(String[] args) {
		IntersectionOfMultipleArrays lzr = new IntersectionOfMultipleArrays();
		int[][] nums = {{3,1,2,4,5},{1,2,3,4},{3,4,5,6}};
		List<Integer> res = lzr.intersection(nums);
		System.out.print(res);
	}
}