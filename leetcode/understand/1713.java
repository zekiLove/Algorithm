class Solution {

	public int minOperations(int[] target, int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		//用map记录target种每个数字的下标位置
		for (int i = 0; i < target.length; i++) {
			map.put(target[i], i);
		}
		List<Integer> p = new ArrayList<>();
		for (int v : arr) {
			if (map.containsKey(v)) {
				int po = map.get(v);
				//利用二分查找和贪心原理找出po在p中使得p能够单调递增的位置
				int it = binarySearch(p, po);
				if(it!=p.size()) {
					//若那个位置有元素了，那就将其代替掉，因为二分查找的算法，po肯定要比原先位置上的数小。
					p.set(it, po);
				}else {
					//若po是最大的那个元素或者p为空，那么就直接添加
					p.add(po);
				}
			}
		}
		return target.length-p.size();
	}

	public int binarySearch(List<Integer> list, int po) {
		if (list.size() == 0 || list.get(list.size() - 1) < po) {
			return list.size();
		}
		int low = 0, high = list.size() - 1;
		while (low < high) {
			int mid = (high-low)/2+low;
			if(list.get(mid)<po) {
				low=mid+1;
			}else {
				high=mid;
			}
		}
		return low;
	}

}
