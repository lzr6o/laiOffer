package Code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class kexin {
	int getMaxIndex(int[] array) {
		Map<Integer,Integer> hashmap = new HashMap<>();
		for (int i=0; i< array.length;i++) {
			hashmap.put(array[i],i);
		}
		Arrays.sort(array);
		int max = Integer.MIN_VALUE;
		for (int i=1; i< array.length;i++) {
			int diff = Math.abs(hashmap.get(array[i])-hashmap.get(array[i-1]));
			max = Math.max(max, diff);
		} 

		return max;
	}

	public static void main(String[] args) {
		kexin test = new kexin();
		int[] array = {4,5,1,2,6,3}; 
		int result = test.getMaxIndex(array);
		System.out.println(result);
	}

}
