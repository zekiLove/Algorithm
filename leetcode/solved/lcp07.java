class Solution {
	
	
//	//动态规划 yyds
//	public int numWays(int n, int[][] relation, int k) {
//		//这里dp[i][j]表示第i轮传递到j手上有多少种方案
//		int dp[][] = new int[k + 1][n];
//		//这步非常的关键，因为是0号选手起手，所以当s=0时，dp[i+1][d] += dp[i][s]，即第一轮到达d的方案个数+1
//		dp[0][0] = 1;
//		for (int i = 0; i < k; i++) {
//			for (int[] edge : relation) {
//				int s = edge[0], d = edge[1];
//				dp[i+1][d] += dp[i][s];
//			}
//		}
//		return dp[k][n-1];
//	}
	
	int sum;
	int dest;
	int res=0;
    public int numWays(int n, int[][] relation, int k) {
    	sum=k;
    	dest=n-1;
    	for(int i=0;i<relation.length;i++) {
    		if(relation[i][0]==0) {
    			findWay(relation,relation[i][1],1);
    		}
    		
    	}
    	
    	return res;
    	
    }

    public void findWay(int[][] r,int l,int k) {
    	if(k==sum) {
    		if(dest==l) {
    			res++;
    		}
    		return;
    	}
    	  	
    	for(int i=0;i<r.length;i++) {
    		if(r[i][0]==l) {
    			findWay(r,r[i][1],k+1);
    		}
    	}
    }
}
