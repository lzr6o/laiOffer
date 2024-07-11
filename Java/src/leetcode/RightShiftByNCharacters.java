package leetcode;
class RightShiftByNCharacters {
	String rightShift(String input, int n) {
		if (input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		n %= arr.length;
		reverse(arr, arr.length - n, arr.length - 1);
		reverse(arr, 0, arr.length - n - 1);
		reverse(arr, 0, arr.length - 1);
		return new String(arr);
	}
	void reverse(char[] arr, int left, int right) {
		while (left < right) {
			char tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
	}
	
	public static void main(String args[]) {
		RightShiftByNCharacters lzr = new RightShiftByNCharacters();
		String input = "abc";
		int n = 4;
		String res = lzr.rightShift(input, n);
		System.out.print(res);
	}
}