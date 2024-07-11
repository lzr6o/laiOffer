package leetcode;

import java.util.HashMap;
import java.util.Map;

class DecodeTheMessage {

	String decodeMessage(String key, String message) {
		Map<Character, Character> map = new HashMap<>();
		map.put(' ', ' ');
		int cnt = 0;
		for (Character c : key.toCharArray()) {
			if (!map.containsKey(c)) {
				map.put(c, (char)('a' + cnt));
				cnt++;
			}
			if (cnt == 26) {
				break;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : message.toCharArray()) {
			sb.append(map.get(c));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		DecodeTheMessage lzr = new DecodeTheMessage();
		String key = "the quick brown fox jumps over the lazy dog";
		String message = "vkbs bs t suepuv";
		String res = lzr.decodeMessage(key, message);
		System.out.print(res);
	}
}