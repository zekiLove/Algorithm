class Solution {
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
