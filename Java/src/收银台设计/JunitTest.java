package 收银台设计;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class JunitTest {
	@Test
	void test1() {
		Solution lzr = new Solution();
		int[] initCashes = { 5, 2, 5, 1 };
		Payment p1 = new Payment(47, new int[] { 0, 0, 0, 0, 1 });
		Payment p2 = new Payment(2, new int[] { 0, 1, 0, 0, 0 });
		Payment p3 = new Payment(1, new int[] { 1, 0, 0, 1, 0 });
		List<Payment> payments = new ArrayList<Payment>() {
			{
				add(p1);
				add(p2);
				add(p3);
			}
		};
		int[] expect = { 3, 2, 5, 0, 1 };
		int[] res = lzr.cashierResult(initCashes, payments);
		for (int i = 0; i < 5; i++) {
			assertEquals(expect[i], res[i]);
		}
	}

	@Test
	void test2() {
		Solution lzr = new Solution();
		int[] initCashes = { 544, 940, 902, 153 };
		Payment p1 = new Payment(257, new int[] { 477, 35, 48, 504, 35 });
		Payment p2 = new Payment(897, new int[] { 280, 725, 896, 448, 3 });
		Payment p3 = new Payment(744, new int[] { 934, 707, 50, 596, 368 });
		Payment p4 = new Payment(228, new int[] { 257, 56, 86, 935, 872 });
		List<Payment> payments = new ArrayList<Payment>() {
			{
				add(p1);
				add(p2);
				add(p3);
				add(p4);
			}
		};
		int[] expect = { 2485, 2459, 926, 0, 0 };
		int[] res = lzr.cashierResult(initCashes, payments);
		for (int i = 0; i < 5; i++) {
			assertEquals(expect[i], res[i]);
		}
	}
}