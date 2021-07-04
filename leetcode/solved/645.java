class Solution {
	public int[] findErrorNums(int[] nums) {
		HashSet<Integer> set = new HashSet<>();

		int res[] = new int[2];
		for (int i = 1; i <= nums.length; i++) {
			set.add(i);
		}

		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i])) {
				set.remove(nums[i]);

			} else {
				res[0] = nums[i];
			}
		}
		for (int x : set) {
			res[1] = x;
		}

		return res;
	}
}
