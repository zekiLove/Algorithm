class Solution {
    //另外一种解法   
 //	public int maxIceCream(int[] costs, int coins) {
//		int arr[] = new int[100001];
//		for (int cost : costs) {
//			arr[cost]++;
//		}
//		int sum = 0;
//
//		for (int i = 1; i < 100001; i++) {
//			if (coins >= i) {
//				int curCount = Math.min(arr[i], coins / i);
//				coins -= i * curCount;
//				sum += curCount;
//			}
//
//		}
//		return sum;
//	}
    public int maxIceCream(int[] costs, int coins) {
    	Arrays.sort(costs);
        int money=0;
        int sum=0;
        for(int i=0;i<costs.length;i++) {
        	int temp = money+costs[i];
        	if(temp>coins) {
        		return sum;
        	}else if(temp == coins){
        		return sum+1;
        	}else {
        		money = temp;
        		sum+=1;
        	}
        }
        return sum;
    }
}
