package Code;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ReverseOnlyVowels {
	String reverse(String str) {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		char[] arr = str.toCharArray();
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			if (set.contains(arr[i]) && set.contains(arr[j])) {
				swap(arr, i++, j--);
			} else if (set.contains(arr[i])) {
				j--;
			} else if (set.contains(arr[j])) {
				i++;
			} else {
				i++;
				j--;
			}
		}
		return new String(arr);
	}
	
	void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static void main(String[] args) {
		ReverseOnlyVowels lzr = new ReverseOnlyVowels();
		String input = "ab";
		String result = lzr.reverse(input);
		System.out.print(result);
	}
}