import java.util.Map.Entry;
class Solution {
HashMap<Integer, HashMap<Integer, List<Integer>>> map = new HashMap<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		getList(0, 0, root);
		List<Integer> col = new ArrayList<>();
		for (Entry<Integer, HashMap<Integer, List<Integer>>> entry : map.entrySet()) {
			col.add(entry.getKey());
		}
		Collections.sort(col);
		for(Integer i : col) {
			HashMap<Integer, List<Integer>> row = map.get(i);
			List<Integer> rowList = new ArrayList<>();
			for (Entry<Integer, List<Integer>> entry : row.entrySet()) {
				rowList.add(entry.getKey());
			}
			Collections.sort(rowList);
			List<Integer> temp = new ArrayList<>();
			for(Integer r : rowList) {
				List<Integer> sameRowNode = row.get(r);
				Collections.sort(sameRowNode);
				temp.addAll(sameRowNode);
			}
			res.add(temp);
		}
		return res;
	}

	public void getList(int row, int col, TreeNode node) {
		HashMap<Integer, List<Integer>> m = map.getOrDefault(col, new HashMap<Integer, List<Integer>>());
		List<Integer> l = m.getOrDefault(row, new ArrayList<Integer>());
		l.add(node.val);
		m.put(row, l);
		map.put(col, m);
		if (node.left != null) {
			getList(row + 1, col - 1, node.left);
		}

		if (node.right != null) {
			getList(row + 1, col + 1, node.right);
		}
	}
}
