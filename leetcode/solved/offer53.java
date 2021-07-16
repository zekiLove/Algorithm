class Solution {
	public int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] >= target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid+1;
			}
		}
		int cur=0;
		for(int i=low;i<nums.length;i++) {
			if(nums[i]==target) {
				cur++;
			}
		}		
		return cur;
	}
}
