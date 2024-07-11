package leetcode;
class RemoveAdjacentRepeatedCharacters {
	String deDup(String input) {
		if (input == null) {
			return null;
		}
		char[] arr = input.toCharArray();
		int end = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] != arr[end - 1]) {
				arr[end++] = arr[i];
			}
		}
		return new String(arr, 0, end);
	}
	
	public static void main(String args[]) {
		RemoveAdjacentRepeatedCharacters lzr = new RemoveAdjacentRepeatedCharacters();
		String input = "aabbbbazw";
		String res = lzr.deDup(input);
		System.out.print(res);
	}
}