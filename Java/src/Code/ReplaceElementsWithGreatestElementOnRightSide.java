package Code;

import java.util.Arrays;

class ReplaceElementsWithGreatestElementOnRightSide {

	int[] replaceElements(int[] arr) {
		int max = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			int tmp = Math.max(max, arr[i]);
			arr[i] = max;
			max = tmp;
		}
		return arr;
	}

	public static void main(String[] args) {
		ReplaceElementsWithGreatestElementOnRightSide lzr = new ReplaceElementsWithGreatestElementOnRightSide();
		int[] arr = { 17, 18, 5, 4, 6, 1 };
		int[] res = lzr.replaceElements(arr);
		System.out.print(Arrays.toString(res));
	}
}