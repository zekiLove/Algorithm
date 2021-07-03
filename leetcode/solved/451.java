class Solution {
	public String frequencySort(String s) {

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			String str = s.substring(i, i + 1);
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		int arr[] = new int[map.size()];
		String arr1[] = new String[arr.length];
		int index = 0;

		for (Entry<String, Integer> entry : map.entrySet()) {
			int x = entry.getValue();
			String str = entry.getKey();
			arr[index] = x;
			arr1[index] = str;
			index++;
		}
		String res="";

		quickSort(arr, arr1, 0, arr.length - 1);
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i];j++) {
				res=res+arr1[i];
			}
		}
		return res;
	}

	public void quickSort(int arr[], String arr1[], int low, int heigh) {
		int l = low;
		int r = heigh;
		if(l>=r) {
			return;
		}
		int temp = arr[l];
		String strTemp = arr1[l];
		while (l < r) {
			while (arr[r] <= temp && l < r) {
				r--;
			}
			
			while (arr[l] >= temp && l < r) {
				l++;
			}

			if (l < r) {
				int t = arr[l];
				arr[l]=arr[r];
				arr[r]=t;
				
				String str = arr1[l];
				arr1[l]=arr1[r];
				arr1[r]=str;
			}
		}
		
		arr[low]=arr[l];
		arr[l]=temp;
		
		arr1[low]=arr1[l];
		arr1[l]=strTemp;
		
		quickSort(arr,arr1,low,r-1);
		quickSort(arr,arr1,r+1,heigh);

	}
}
