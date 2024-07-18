package Code;
class SquareRootI {
	int sqrt(int x) {
		int res = 0;
	    int left = 1, right = x;
	    while (left <= right) {
	        int mid = left + (right - left)/2;
	        // upper bound的形式，因为我们要找的ans要是最接近于x的最大的数，利用upper bound
	        if (mid <= x/mid) {
	        	left = mid + 1;
	        	res = mid;
	        } else {
	        	right = mid - 1;
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		SquareRootI lzr = new SquareRootI();
		int x = 508382882;
		int result = lzr.sqrt(x);
		System.out.print(result);
	}
}