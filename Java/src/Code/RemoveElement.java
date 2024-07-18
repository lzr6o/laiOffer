package Code;

class RemoveElement {
	int removeElement(int[] nums, int val) {
		int cnt = 0;
		for (int num : nums) {
			if (num != val) {
				nums[cnt++] = num;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		RemoveElement lzr = new RemoveElement();
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		int res = lzr.removeElement(nums, val);
		System.out.print(res);
	}
}