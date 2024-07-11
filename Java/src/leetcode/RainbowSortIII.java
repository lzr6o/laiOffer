package leetcode;
import java.util.Arrays;

class RainbowSortIII {
	 int[] rainbowSortIII(int[] arr, int k) {
	      if (arr == null || arr.length < 2) {
	        return arr;
	    }
	    int left = 0;
	    int right = arr.length - 1;
	    for (int round = 1; round <= k / 2; round++) {
			int leftColor = round;
	        int rightColor = k + 1 - round;
	        for (int i = left; i <= right; i++) {
	            if (arr[i] == leftColor) {
	                swap(arr, i, left);
	                left++;
	            } else if (arr[i] == rightColor) {
	                swap(arr, i, right);
	                i--;
	                right--;
	            }
	        }
	    }
	    return arr;
	}

	void swap(int[] arr, int left, int right) {
	    int tmp = arr[left];
	    arr[left] = arr[right];
	    arr[right] = tmp;
	}
	
	public static void main(String[] args) {
		RainbowSortIII lzr = new RainbowSortIII();
		int[] arr = { 3, 1, 5, 5, 1, 4, 2 };
		int k = 5;
		int[] res = lzr.rainbowSortIII(arr, k);
		System.out.print(Arrays.toString(res));
	}
}