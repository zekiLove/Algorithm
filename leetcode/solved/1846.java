class Solution {
	public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		int n = arr.length;
		int count[] = new int[n + 1];
		for (int i = 0; i < n; i++) {
			count[Math.min(n, arr[i])]++;
		}

		int miss = 0;
		for (int i = 1; i <= n; i++) {
			if (count[i] == 0) {
				miss++;
			} else {
				miss -= Math.min(miss, count[i] - 1);
			}
		}
		return n-miss;
	}
}
