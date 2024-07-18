package Code;
import java.util.Arrays;

class WiggleSort {
	void wiggleSort(int[] nums) {
		for (int i = 1; i < nums.length; i += 2) {
			if (nums[i] < nums[i - 1]) {
				swap(nums, i - 1, i);
			}
		}
	}
	
	void swap(int[] arr, int left, int right) {
		int tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
	
	public static void main(String[] args) {
		WiggleSort lzr = new WiggleSort();
		int[] nums = { 1, 5, 1, 1, 6, 4 };
		lzr.wiggleSort(nums);
		System.out.print(Arrays.toString(nums));
	}
}
