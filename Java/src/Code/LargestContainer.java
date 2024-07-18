package Code;
class LargestContainer {
	int largest(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		int vol = Integer.MIN_VALUE;
		while (i < j) {
			vol = Math.max(vol, (j - i) * Math.min(arr[i], arr[j]));
			if (arr[i] < arr[j]) {
				i++;
			} else {
				j--;
			}
		}
		return vol;
	}

	public static void main(String[] args) {
		LargestContainer lzr = new LargestContainer();
		int[] arr = { 1, 3, 2, 4, 6, 6, 4, 2 };
		int result = lzr.largest(arr);
		System.out.print(result);
	}
}