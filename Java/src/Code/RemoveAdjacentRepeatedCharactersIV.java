package Code;

class RemoveAdjacentRepeatedCharactersIV {
	String deDup(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] arr = input.toCharArray();
		int end = -1;
		for (int i = 0; i < arr.length; i++) {
			if (end == -1 || arr[i] != arr[end]) {
				arr[++end] = arr[i];
			} else {
				while (i + 1 < arr.length && arr[i + 1] == arr[end]) {
					i++;
				}
				end--;
			}
		}
		return new String(arr, 0, end + 1);
	}

	public static void main(String args[]) {
		RemoveAdjacentRepeatedCharactersIV lzr = new RemoveAdjacentRepeatedCharactersIV();
		String input = "abbbbazw";
		String res = lzr.deDup(input);
		System.out.print(res);
	}
}