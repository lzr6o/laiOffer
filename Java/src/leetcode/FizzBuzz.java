package leetcode;

import java.util.ArrayList;
import java.util.List;

class FizzBuzz {

	List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				res.add("FizzBuzz");
			} else if (i % 3 == 0) {
				res.add("Fizz");
			} else if (i % 5 == 0) {
				res.add("Buzz");
			} else {
				res.add(Integer.toString(i));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		FizzBuzz lzr = new FizzBuzz();
		int n = 15;
		List<String> res = lzr.fizzBuzz(n);
		System.out.print(res);
	}
}