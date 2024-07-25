package Code;

class RemoveAdjacentRepeatedCharactersIII {
	String deDup(String input) {
		if (input == null || input.length() < 2) {
			return input;
		}
		char[] arr = input.toCharArray();
		int slow = 0;
		for (int fast = 0; fast < arr.length; fast++) {
			if (fast + 1 < arr.length && arr[fast] == arr[fast + 1]) {
				while (fast + 1 < arr.length && arr[fast] == arr[fast + 1]) {
					fast++;
				}
			} else {
				arr[slow++] = arr[fast];
			}
		}
		return new String(arr, 0, slow);
	}

	public static void main(String[] args) {
		RemoveAdjacentRepeatedCharactersIII lzr = new RemoveAdjacentRepeatedCharactersIII();
		String input = "caaaabbbc";
		String res = lzr.deDup(input);
		System.out.print(res);
	}
}