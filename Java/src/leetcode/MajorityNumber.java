package leetcode;
class MajorityNumber {
	int majority(int[] arr) {
		int res = 0, cnt = 0;
		for (int num : arr) {
			if (cnt == 0) {
				res = num;
			}
			cnt += num == res ? 1 : -1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		MajorityNumber lzr = new MajorityNumber();
		int[] arr = {1, 2, 1, 2, 1};
		int res = lzr.majority(arr);
		System.out.println(res);
	}
}