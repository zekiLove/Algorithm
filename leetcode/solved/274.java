

class Solution {

	public int hIndex(int[] citations) {
		int arr[] = citations;
		Arrays.sort(arr);
		int n = arr.length;
		int index = 0;
		int preMax = 0;
		while (index < n) {
			int x = arr[index];// 最少发表那篇发表了多少次
			int s = n - index;// 一共几篇
			if (x >= s && preMax <= s) {// 如果最少发表那篇发表的次数大于剩下的文章数
				return s;
			}
			preMax = x;
			index++;
		}
		return 0;
	}
}
