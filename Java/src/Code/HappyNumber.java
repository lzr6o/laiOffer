package Code;

import java.util.HashSet;
import java.util.Set;

class HappyNumber {
	boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int sum = 0;
		while (n != 1) {
			sum = 0;
			while (n > 0) {
				sum += (n % 10) * (n % 10);
				n = n / 10;
			}
			if (!set.add(sum)) {
				return false;
			}
			n = sum;
		}
		return true;
	}
	
	public static void main(String[] args) {
		HappyNumber lzr = new HappyNumber();
		int n = 19;
		boolean res = lzr.isHappy(n);
		System.out.print(res);
	}
}