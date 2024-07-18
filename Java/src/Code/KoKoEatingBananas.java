package Code;
class KoKoEatingBananas {
	int minEatingSpeed(int[] piles, int h) {
		int R = Integer.MIN_VALUE;
		for (int pile : piles) {
			R = Math.max(R, pile);
		}
		int L = 1;
		while (L <= R) {
			int M = L + (R - L) / 2;
			int hours = 0;
			for (int pile : piles) {
				hours += (pile + M - 1) / M;
			}
			if (hours > h) {
				L = M + 1;
			} else {
				R = M - 1;
			}
		}
		return L;
	}

	public static void main(String[] args) {
		KoKoEatingBananas lzr = new KoKoEatingBananas();
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		int res = lzr.minEatingSpeed(piles, h);
		System.out.print(res);
	}
}