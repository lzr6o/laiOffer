package leetcode;
import java.util.ArrayDeque;

class OnlineStockSpan {
	ArrayDeque<int[]> stack = new ArrayDeque<>();

	OnlineStockSpan() {
		stack = new ArrayDeque<>();
	}

	int next(int price) {
		int cnt = 1;
		while (!stack.isEmpty() && price >= stack.peekLast()[0]) {
			cnt += stack.pollLast()[1];
		}
		stack.offerLast(new int[] { price, cnt });
		return cnt;
	}

	public static void main(String[] args) {
		OnlineStockSpan lzr = new OnlineStockSpan();
		System.out.println(lzr.next(100));
		System.out.println(lzr.next(80));
		System.out.println(lzr.next(60));
		System.out.println(lzr.next(70));
		System.out.println(lzr.next(60));
		System.out.println(lzr.next(75));
		System.out.println(lzr.next(85));
	}
}