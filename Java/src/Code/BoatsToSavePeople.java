package Code;

import java.util.Arrays;

class BoatsToSavePeople {
	int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int res = 0;
		int L = 0;
		int R = people.length - 1;
		while (L <= R) {
			if (people[L] + people[R] <= limit) {
				L++;
			}
			R--;
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		BoatsToSavePeople lzr = new BoatsToSavePeople();
		int[] people = { 3, 2, 2, 1 };
		int limit = 3;
		int res = lzr.numRescueBoats(people, limit);
		System.out.print(res);
	}
}