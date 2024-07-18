package Code;

class AscendingTriple {

	boolean existIJK(int[] nums) {
		if (nums.length < 3) {
			return false;
		}
		int small = Integer.MAX_VALUE;
		int big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} else if (n <= big) {
				big = n;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		AscendingTriple lzr = new AscendingTriple();
		int[] arr = { 6, 7, 1, 2 };
		boolean result = lzr.existIJK(arr);
		System.out.print(result);
	}
}