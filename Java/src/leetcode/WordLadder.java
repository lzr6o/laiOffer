package leetcode;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class WordLadder {
	int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (wordList == null || wordList.size() == 0) {
			return 0;
		}
		// hashset的好处：去重也完成了
		// 开始端
		HashSet<String> start = new HashSet<>();
		// 结束端
		HashSet<String> end = new HashSet<>();
		// 所有字符串的字典
		HashSet<String> dic = new HashSet<>(wordList);
		start.add(beginWord);
		end.add(endWord);
		if (!dic.contains(endWord)) {
			return 0;
		}
		// 经历过上面的一系列判定，到这里的时候，若是有路径，则最小是2，所以以2开始
		return bfs(start, end, dic, 2);
	}

	int bfs(HashSet<String> st, HashSet<String> ed, HashSet<String> dic, int l) {
		// 双端查找的时候，若是有任意一段出现了“断裂”，也就是说明不存在能够连上的路径，则直接返回0
		if (st.size() == 0) {
			return 0;
		}
		if (st.size() > ed.size()) {// 双端查找，为了优化时间，永远用少的去找多的，比如开始的时候塞进了1000个，而结尾只有3个，则肯定是从少的那一端开始走比较好
			return bfs(ed, st, dic, l);
		}
		// BFS的标记行为，即使用过的不重复使用
		dic.removeAll(st);
		// 收集下一层临近点
		HashSet<String> next = new HashSet<>();
		for (String s : st) {
			char[] arr = s.toCharArray();
			for (int i = 0; i < arr.length; i++) {
				char tmp = arr[i];
				// 变化
				for (char c = 'a'; c <= 'z'; c++) {
					if (tmp == c) {
						continue;
					}
					arr[i] = c;
					String nstr = new String(arr);
					if (dic.contains(nstr)) {
						if (ed.contains(nstr)) {
							return l;
						} else {
							next.add(nstr);
						}
					}
				}
				// 复原
				arr[i] = tmp;
			}
		}
		return bfs(next, ed, dic, l + 1);
	}

	public static void main(String[] args) {
		WordLadder lzr = new WordLadder();
		String beginWord = "hit";
		String endWord = "cog";
		String[] arr = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> wordList = Arrays.asList(arr);
		int res = lzr.ladderLength(beginWord, endWord, wordList);
		System.out.print(res);
	}
}