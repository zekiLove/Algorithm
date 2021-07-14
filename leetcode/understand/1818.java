	public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int sum = 0;
		int modVal = 1000000007;
		int arr[] = new int[n];
		System.arraycopy(nums1, 0, arr, 0, n);
		Arrays.sort(arr);
		int maxV = 0;
		for (int i = 0; i < n; i++) {
			int m = Math.abs(nums1[i] - nums2[i]);
			sum = (sum + m) % modVal;
			int j = binarySearch(arr, nums2[i]);
			if (j < n) {
				maxV = Math.max(maxV, m - (arr[j] - nums2[i]));
			}
			if (j > 0) {
				maxV = Math.max(maxV, m - (nums2[i] - arr[j - 1]));
			}
		}

		return (sum - maxV + modVal) % modVal;
	}
  //这个方法用于寻找在arr种第一个大于target的数的索引
	public int binarySearch(int r[], int target) {
		int n = r.length;
		int low = 0;
		int heigh = n - 1;
		if (r[heigh] < target) {
			return heigh + 1;
		}
		while (low < heigh) {
			int mid = (heigh - low) / 2 + low;
			if (r[mid] < target) {
				low = mid + 1;
			} else {
				heigh = mid;
			}

		}
		return low;
	}
