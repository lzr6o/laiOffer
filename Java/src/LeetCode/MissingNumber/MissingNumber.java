package LeetCode.MissingNumber;

class MissingNumber {
	int missing(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i + 1 && arr[i] != arr.length + 1) {
				swap(arr, i, arr[i] - 1);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return arr.length + 1;
	}

	void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String args[]) {
		MissingNumber lzr = new MissingNumber();
		int[] arr = { 3, 1, 2, 5 };
		int res = lzr.missing(arr);
		System.out.print(res);
	}
}