package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RepeatedDNASequences {
	List<String> findRepeatedDnaSequences(String s) {
		Set<String> set = new HashSet<>(), res = new HashSet<>();
		char[] dna = s.toCharArray();
		for (int i = 0; i <= dna.length - 10; i++) {
			String str = String.valueOf(dna, i, 10);
			if (!set.add(str)) {
				res.add(str);
			}
		}
		return new ArrayList<>(res);
	}

	public static void main(String[] args) {
		RepeatedDNASequences lzr = new RepeatedDNASequences();
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> res = lzr.findRepeatedDnaSequences(s);
		System.out.print(res);
	}
}