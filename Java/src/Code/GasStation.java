package Code;

class GasStation {
	int canCompleteCircuit(int[] gas, int[] cost) {
		int head = 0, diff = 0, surplus = 0;
		for (int i = 0; i < gas.length; i++) {
			surplus += gas[i] - cost[i];
			diff += gas[i] - cost[i];
			if (diff < 0) {
				diff = 0;
				head = i + 1;
			}
		}
		return surplus >= 0 ? head : -1;
	}
	
	public static void main(String[] args) {
		GasStation lzr = new GasStation();
		int[] gas = { 2, 3, 4 };
		int[] cost = { 3, 4, 3 };
		int res = lzr.canCompleteCircuit(gas, cost);
		System.out.print(res);
	}
}