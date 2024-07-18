package 可信.收银台设计;

import java.util.Arrays;
import java.util.List;

class Solution {
	int[] CASH = { 1, 5, 10, 50, 100 };
	int[] REMAIN;
	int[] EXCHANGE;

	void initRemain(int[] arr) {
		REMAIN = new int[5];
		for (int i = 0; i < arr.length; i++) {
			REMAIN[i] = arr[i];
		}
	}

	void updateRemain(int[] arr, int num) {
		for (int i = 0; i < arr.length; i++) {
			REMAIN[i] += num * arr[i];
		}
	}

	int[] cashierResult(int[] initCashes, List<Payment> payments) {
		initRemain(initCashes);
		System.out.println("Initial Cash Remain" + Arrays.toString(REMAIN) + "\n");
		for (Payment payment : payments) {
			updateRemain(payment.paidCashes, 1);
			int needToExchange = getPaidAmount(payment) - payment.price;
			System.out.println("Need to Pay : " + payment.price);
			System.out.println("Need to Exchange : " + needToExchange);
			int num = getExchangeMethod(needToExchange, payment.paidCashes);
			updateRemain(num == -1 ? EXCHANGE : payment.paidCashes, -1);
			System.out.println("Cur Cash Remain : " + Arrays.toString(REMAIN));
			System.out.println();
		}
		return REMAIN;
	}

	int getPaidAmount(Payment payment) {
		int paid = 0;
		for (int i = 0; i < CASH.length; i++) {
			paid += CASH[i] * payment.paidCashes[i];
		}
		System.out.println("Get : " + paid);
		return paid;
	}

	int getExchangeMethod(int price, int[] paidCashes) {
		EXCHANGE = new int[] { 0, 0, 0, 0, 0 };
		for (int i = CASH.length - 1; i >= 0; i--) {
			if (price >= CASH[i]) {
				if (price / CASH[i] <= REMAIN[i]) {
					EXCHANGE[i] = (price - (price % CASH[i])) / CASH[i];
					price = price % CASH[i];
				} else {
					EXCHANGE[i] = REMAIN[i];
					price -= CASH[i] * REMAIN[i];
				}
			}
		}
		System.out.println("Exchange Method : " + Arrays.toString(EXCHANGE));
		return price == 0 ? -1 : 1;
	}
}


