package Code;

class SumOfSquareNumbers {
	boolean judgeSquareSum(int c) {
		long right = 1;
		while (right * right <= c) {
			right++;
		}
		long left = 0;
		while (left <= right) {
			long sum = left * left + right * right;
			if (sum == c) {
				return true;
			} else if (sum < c) {
				left++;
			} else {
				right--;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SumOfSquareNumbers lzr = new SumOfSquareNumbers();
		int c = 2147482647;
		boolean res = lzr.judgeSquareSum(c);
		System.out.print(res);
	}
}