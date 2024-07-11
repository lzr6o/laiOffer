package leetcode;

class TimeNeededToBuyTickets {

	int timeRequiredToBuy(int[] tickets, int k) {
		int cnt = 0;
		while (tickets[k] != 0) {
			for (int i = 0; i < tickets.length; i++) {
				if (tickets[i] != 0) {
					tickets[i] = tickets[i] - 1;
					cnt++;
				}
				if (tickets[k] == 0) {
					break;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		TimeNeededToBuyTickets lzr = new TimeNeededToBuyTickets();
		int[] tickets = { 5, 1, 1, 1 };
		int k = 0;
		int res = lzr.timeRequiredToBuy(tickets, k);
		System.out.print(res);
	}
}