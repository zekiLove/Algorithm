class Solution {
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
