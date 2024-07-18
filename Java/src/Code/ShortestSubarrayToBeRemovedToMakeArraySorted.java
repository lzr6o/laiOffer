package Code;
class ShortestSubarrayToBeRemovedToMakeArraySorted {
	int findLengthOfShortestSubarray(int[] arr) {
		int tail = arr[arr.length - 1];
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > tail) {
				int max = i - 1 >= 0 ? arr[i - 1] : Integer.MIN_VALUE;
				int j = arr.length - 1;
				 while (arr[j] >= max && j > i) {
					 j--;
				}
				res = j - i;
				break;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		ShortestSubarrayToBeRemovedToMakeArraySorted lzr = new ShortestSubarrayToBeRemovedToMakeArraySorted();
		int[] arr = { 2, 2, 2, 1, 1, 1 };
		int res = lzr.findLengthOfShortestSubarray(arr);
		System.out.print(res);
	}
}