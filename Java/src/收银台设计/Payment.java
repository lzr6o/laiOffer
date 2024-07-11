package 收银台设计;

import java.util.Arrays;
import java.util.Locale;

class Payment {
	int price;
	int[] paidCashes;
	
	Payment(int price, int[] paidCashes) {
		this.price = price;
		this.paidCashes = paidCashes;
	}
	
	public String toString() {
		return String.format(Locale.ROOT, "[%d, %s ]", this.price, Arrays.toString(this.paidCashes));
	}
}