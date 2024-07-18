package Code;
import java.util.Arrays;

class TriangleCount {
	int triangleCount(int[] S) {
		Arrays.sort(S);
		int count = 0;
		for (int i = 2; i < S.length; i++) {
			int left = 0;
			int right = i - 1;
			while (left < right) {
				int sum = S[left] + S[right];
				if (sum <= S[i]) {
					left++;
				} else {
					count += right - left;
					right--;
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		TriangleCount lzr = new TriangleCount();
		int[] S = { 4, 4, 4, 4 };
		int res = lzr.triangleCount(S);
		System.out.print(res);
	}
}