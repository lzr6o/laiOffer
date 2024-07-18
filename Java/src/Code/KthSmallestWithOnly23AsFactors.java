package Code;
import java.util.Arrays;

class KthSmallestWithOnly23AsFactors {
	int kth(int k) {
		int two = 0, three = 0;
		int[] arr = new int[k];
		arr[0] = 1;
		for (int i = 1; i < k; i++) {
			int min = arr[two] * 2 <= arr[three] * 3 ? arr[two] * 2 : arr[three] * 3;
			arr[i] = min;
			if (min == arr[two] * 2)
				two++;
			if (min == arr[three] * 3)
				three++;
		}
		System.out.println(Arrays.toString(arr));
		return arr[k - 1];
	}

	public static void main(String[] args) {
		KthSmallestWithOnly23AsFactors lzr = new KthSmallestWithOnly23AsFactors();
		int k = 8;
		long result = lzr.kth(k);
		System.out.print(result);
	}
}