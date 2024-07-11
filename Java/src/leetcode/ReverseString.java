package leetcode;
class ReverseString {
	String reverse(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			swap(arr, left++, right--);
		}
		return new String(arr);
	}

	void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String args[]) {
		ReverseString lzr = new ReverseString();
		String input = "am in oac";
		String res = lzr.reverse(input);
		System.out.print(res);
	}
}