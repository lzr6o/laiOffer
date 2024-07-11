package leetcode;
import java.util.ArrayList;
import java.util.List;

class MajorityNumberII {
	List<Integer> majority(int[] arr) {
		int one = 0;
		int two = 0;
		int oneCnt = 0;
		int twoCnt = 0;
		for (int num : arr) {
			if (num == one) {
				oneCnt++;
			} else if (num == two) {
				twoCnt++;
			} else if (oneCnt == 0) {
				oneCnt = 1;
				one = num;
			} else if (twoCnt == 0) {
				twoCnt = 1;
				two = num;
			} else {
				oneCnt--;
				twoCnt--;
			}
		}
		oneCnt = 0;
		twoCnt = 0;
		for (int num : arr) {
			if (num == one) {
				oneCnt++;
			} else if (num == two) {
				twoCnt++;
			}
		}
		List<Integer> res = new ArrayList<>();
		if (oneCnt > arr.length / 3) {
			res.add(one);
		}
		if (twoCnt > arr.length / 3) {
			res.add(two);
		}
		return res;
	}

	public static void main(String[] args) {
		MajorityNumberII lzr = new MajorityNumberII();
		int[] arr = { 1, 2, 2, 3, 1, 3 };
		List<Integer> res = lzr.majority(arr);
		System.out.println(res);
	}
}