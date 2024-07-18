package Code;
import java.util.ArrayList;
import java.util.List;

class PermutationSequence {
	String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> num = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            num.add(i);
        }
        for (int i = 0, l = k - 1; i < n; i++) {
            fact /= (n - i);
            int index = (l / fact);
            sb.append(num.remove(index));
            l -= index * fact;
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		PermutationSequence lzr = new PermutationSequence();
		int n = 3;
		int k = 3;
		String res = lzr.getPermutation(n, k);
		System.out.print(res);
	}
}