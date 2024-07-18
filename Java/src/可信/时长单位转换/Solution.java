package 可信.时长单位转换;

import java.util.HashMap;
import java.util.Map;

class Solution {
	Map<String, Integer> map;
	int[] LARGER = { 60, 60, 24, 31, 22 };
	String[] UNIT = {"second", "minute", "hour", "day", "month", "year"};
	
	String unitTransform(String inputStr) {
		map = new HashMap<String, Integer>() {
			{
				put("second", 0);
				put("minute", 1);
				put("hour", 2);
				put("day", 3);
				put("month", 4);
				put("year", 5);
			}
		};
		String[] arr = inputStr.split(" ");
		int num = Integer.parseInt(arr[0]);
		String unit = arr[1];
		int start = map.get(unit);
		String res = "";
		while (num > 0 && start < LARGER.length) {
			int remain = num % LARGER[start];
			if (remain != 0) {
				res = " " + remain + " " + UNIT[start] + res;
			}
			num /= LARGER[start];
			start++;
		}
		if (num > 0) {
			res = num + " " + UNIT[start] + res;
		}
		return res.strip();
	}
}