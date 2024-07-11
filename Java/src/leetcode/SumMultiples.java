package leetcode;

class SumMultiples {
	int sumOfMultiples(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
        	if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
        		sum += i;
        	}
        }
		return sum;
    }
	
	public static void main(String[] args) {
		SumMultiples lzr = new SumMultiples();
		int n = 7;
		int res = lzr.sumOfMultiples(n);
		System.out.print(res);
	}
}