package Code;

class FirstMissingPositive {

	int firstMissingPositive(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int num = nums[i];
			if (num < 1 || num >= nums.length || nums[num - 1] == num) {
				i++;
			} else {
				swap(nums, i, num - 1);
			}
		}
		for (i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return nums.length + 1;
	}

	void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String[] args) {
		FirstMissingPositive lzr = new FirstMissingPositive();
		int[] nums = { 1, 1 };
		int res = lzr.firstMissingPositive(nums);
		System.out.print(res);
	}
}