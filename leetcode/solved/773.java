

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

	public int slidingPuzzle(int[][] board) {
		StringBuffer first = getString(board);
		StringBuffer answer = new StringBuffer("123450");
		if (first.toString().equals("123450")) {
			return 0;
		}

		Queue<StringBuffer> que = new LinkedList<>();
		HashSet<String> isVis = new HashSet<>();
		isVis.add(first.toString());
		que.offer(first);
		int step = 0;
		while (!que.isEmpty()) {
			step++;
			int size = que.size();
			for (int i = 0; i < size; i++) {
				StringBuffer indexStr = que.poll();
				for (StringBuffer str : getStatus(indexStr)) {
					if (!isVis.contains(str.toString())) {
						if (str.toString().equals(answer.toString())) {
							return step;
						}
						isVis.add(str.toString());
						que.offer(str);
					}
				}
			}
		}
		return -1;

	}

	public StringBuffer leftMove(StringBuffer str) {
		int zeroIndex = str.indexOf("0");
		StringBuffer s = new StringBuffer();
		if (zeroIndex != 0 && zeroIndex != 3) {
			s.append(str);
			String temp = s.substring(zeroIndex - 1, zeroIndex);

			s.replace(zeroIndex - 1, zeroIndex, "0");
			s.replace(zeroIndex, zeroIndex + 1, temp);
			return s;
		} else {
			return null;
		}
	}

	public StringBuffer rightMove(StringBuffer str) {
		int zeroIndex = str.indexOf("0");
		StringBuffer s = new StringBuffer();
		if (zeroIndex != 2 && zeroIndex != 5) {
			s.append(str);
			String temp = s.substring(zeroIndex + 1, zeroIndex + 2);

			s.replace(zeroIndex + 1, zeroIndex + 2, "0");
			s.replace(zeroIndex, zeroIndex + 1, temp);
			return s;
		} else {
			return null;
		}
	}

	public StringBuffer upMove(StringBuffer str) {
		int zeroIndex = str.indexOf("0");
		StringBuffer s = new StringBuffer();
		if (zeroIndex != 0 && zeroIndex != 1 && zeroIndex != 2) {
			s.append(str);
			String temp = s.substring(zeroIndex - 3, zeroIndex - 2);

			s.replace(zeroIndex - 3, zeroIndex - 2, "0");
			s.replace(zeroIndex, zeroIndex + 1, temp);
			return s;
		} else {
			return null;
		}
	}

	public StringBuffer downMove(StringBuffer str) {
		int zeroIndex = str.indexOf("0");
		StringBuffer s = new StringBuffer();
		if (zeroIndex != 3 && zeroIndex != 4 && zeroIndex != 5) {
			s.append(str);
			String temp = s.substring(zeroIndex + 3, zeroIndex + 4);

			s.replace(zeroIndex + 3, zeroIndex + 4, "0");
			s.replace(zeroIndex, zeroIndex + 1, temp);
			return s;
		} else {
			return null;
		}
	}

	public List<StringBuffer> getStatus(StringBuffer str) {
		List<StringBuffer> list = new ArrayList<>();
		if (leftMove(str) != null) {
			list.add(leftMove(str));
		}

		if (rightMove(str) != null) {
			list.add(rightMove(str));
		}

		if (upMove(str) != null) {
			list.add(upMove(str));
		}

		if (downMove(str) != null) {
			list.add(downMove(str));
		}

		return list;
	}

	public StringBuffer getString(int arr[][]) {
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				str.append(arr[i][j]);
			}
		}
		return str;
	}
}
