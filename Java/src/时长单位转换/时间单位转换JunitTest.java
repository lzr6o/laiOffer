package 时长单位转换;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class 时间单位转换JunitTest {
	@Test
	void test1() {
		Solution lzr = new Solution();
		String inputStr = "489607 minute";
		String res = lzr.unitTransform(inputStr);
		assertEquals(res, "10 month 30 day 7 minute");
	}
	
	@Test
	void test2() {
		Solution lzr = new Solution();
		String inputStr = "530323200 second";
		String res = lzr.unitTransform(inputStr);
		assertEquals(res, "9 year");
	}
	
	@Test
	void test3() {
		Solution lzr = new Solution();
		String inputStr = "21 month";
		String res = lzr.unitTransform(inputStr);
		assertEquals(res, "21 month");
	}
}