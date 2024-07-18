package Code;
import java.util.ArrayList;
import java.util.List;

class MissingRanges {
	List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		int low = lower, up = upper;
		boolean overflow = false;
		for (int i = 0; i < nums.length; i++) {
			if (low < nums[i]) {
				res.add(getRange(low, nums[i] - 1));
			}
			low = nums[i] + 1;
			if (low == Integer.MIN_VALUE) {
				overflow = true;
				break;
			}
		}
		if (low <= up && overflow == false) {
			res.add(getRange(low, up));
		}
		return res;
	}

	String getRange(int a, int b) {
		if (a == b) {
			return a + "";
		} else {
			return a + "->" + b;
		}
	}

	public static void main(String[] args) {
		MissingRanges lzr = new MissingRanges();
		int[] nums = { 0, 1, 3, 50, 75 };
		int lower = 0;
		int upper = 99;
		List<String> res = lzr.findMissingRanges(nums, lower, upper);
		System.out.print(res);
	}
}