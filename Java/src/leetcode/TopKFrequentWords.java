package leetcode;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashMap;

class TopKFrequentWords {
	String[] topKFrequent(String[] combo, int k) {
		if (combo.length == 0) {
			return new String[0];
		}
		Map<String, Integer> freqMap = getFreqMap(combo);
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		return freqArray(minHeap);
	}
	
	Map<String, Integer> getFreqMap(String[] combo) {
		Map<String, Integer> freqMap = new HashMap<>();
		for (String s : combo) {
			Integer freq = freqMap.get(s);
			if (freq == null) {
				freqMap.put(s, 1);
			} else {
				freqMap.put(s, freq + 1);
			}
		}
		return freqMap;
	}
	
	String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap) {
		String[] res = new String[minHeap.size()];
		for (int i = minHeap.size() - 1; i >= 0; i--) {
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}
	
	public static void main(String args[]) {
		TopKFrequentWords lzr = new TopKFrequentWords();
		String[] combo = {"apple", "banana", "apple", "orange", "apple", "banana", "watermelon", "orange"};
		int k = 3;
		String[] res = lzr.topKFrequent(combo, k);
		for (String s : res) {
			System.out.print(s + " ");
		}
	}
}