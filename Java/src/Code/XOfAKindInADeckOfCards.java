package Code;
import java.util.HashMap;
import java.util.Map;

class XOfAKindInADeckOfCards {
	boolean hasGroupsSizeX(int[] deck) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int card : deck) {
			if (!map.containsKey(card)) {
				map.put(card, 1);
			} else {
				map.put(card, map.get(card) + 1);
			}
		}
		int g = -1;
		for (int val : map.values()) {
			g = g == -1 ? val : gcd(g, val);
		}
		return g >= 2;
	}

	int gcd(int x, int y) {
		return x == 0 ? y : gcd(y % x, x);
	}

	public static void main(String[] args) {
		XOfAKindInADeckOfCards lzr = new XOfAKindInADeckOfCards();
		int[] deck = { 1, 1, 1, 1, 2, 2, 2, 2 };
		boolean res = lzr.hasGroupsSizeX(deck);
		System.out.print(res);
	}
}