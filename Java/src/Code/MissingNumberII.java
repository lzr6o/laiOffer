package Code;
class MissingNumberII {
	int missing(int[] array) {
		if (array.length <= 1) {
			return 1;
		}
		int left = 0;
		int right = array.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == mid + 1) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left + 1;
	}
	
	public static void main(String[] args) {
		MissingNumberII lzr = new MissingNumberII();
		int[] array = { 1, 2, 3 };
		int result = lzr.missing(array);
		System.out.print(result);
	}
}