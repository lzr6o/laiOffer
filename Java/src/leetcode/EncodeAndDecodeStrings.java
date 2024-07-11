package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class EncodeAndDecodeStrings {

	String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(new String(str.length() + "#" + str));
		}
		return sb.toString();
	}

	List<String> decode(String s) {
		List<String> res = new ArrayList<>();
		int i = 0;
		while (i < s.length()) {
			int j = i;
			while (s.charAt(j) != '#') {
				j++;
			}
			int len = Integer.parseInt(s.substring(i, j));
			res.add(s.substring(j + 1, j + 1 + len));
			i = j + 1 + len;
		}
		return res;
	}

	public static void main(String[] args) {
		EncodeAndDecodeStrings lzr = new EncodeAndDecodeStrings();
		List<String> strs = Arrays.asList("Hello", "World");
		String encode = lzr.encode(strs);
		System.out.print(encode + '\n');
		List<String> decode = lzr.decode(encode);
		for (String str : decode) {
			System.out.print(str + " ");
		}
	}
}