package leetcode;
import java.util.Arrays;

class SuperUglyNumber {
	int nthSuperUglyNumber(int n, int[] primes) {
		int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int primesNumber = primes.length;
        int min = 1;
        int next = 1;
        int[] primeIndexes = new int[primesNumber];
        int[] tempPrimes = new int[primesNumber];
        Arrays.fill(tempPrimes, 1);
        for (int i = 0; i < n; i++) {
            uglyNumbers[i] = min;
            min = Integer.MAX_VALUE;
            for (int j = 0; j < tempPrimes.length; j++) {
                if (tempPrimes[j] == next) {
                    tempPrimes[j] = primes[j] * uglyNumbers[primeIndexes[j]];
                    primeIndexes[j]++;
                }
                min = Math.min(min, tempPrimes[j]);
            }
            next = min;
        }
        return uglyNumbers[n - 1];
	}
	
	public static void main(String[] args) {
		SuperUglyNumber lzr = new SuperUglyNumber();
		int n = 12;
		int[] primes = { 2, 7, 13, 19 };
		int res = lzr.nthSuperUglyNumber(n, primes);
		System.out.print(res);
	}
}