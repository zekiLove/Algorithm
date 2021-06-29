class Solution {
	public String convertToTitle(int columnNumber) {
		HashMap<Integer, String> map = new HashMap<>();
		for (int i = 1; i <= 26; i++) {
			map.put(i, (char)(64 + i) + "");
		}
		String res = "";
		boolean flag = false;
		while (columnNumber != 0) {
			int shang = columnNumber / 26;
			int yushu = columnNumber % 26;
			
			if (flag) {
				yushu = yushu - 1;
			}


			if (yushu == 0 && shang!=0) {
				res = map.get(26) + res;
				flag = true;
			}

			if (yushu != 0) {
				res = map.get(yushu) + res;
				flag = false;
			}
			columnNumber=shang;
		}		
		return res;
	}
}
