
class Solution {
    int res = 0;
//另外一种解法，暴力枚举    
//	public int maxPoints(int[][] points) {
//        int n = points.length;
//    	int ans=1;
//        for(int i=0;i<n;i++) {
//            if(ans>=n-i){
//                return ans;
//            }
//        	int x[] = points[i];
//        	for(int j=i+1;j<n;j++) {
//        		int y[] = points[j];
//        		int sum=2;
//        		for(int k=j+1;k<n;k++) {
//        			int p[] = points[k];
//        			int s1 = (x[1]-y[1]) * (y[0]-p[0]);
//        			int s2 = (x[0]-y[0]) * (y[1]-p[1]);
//        			if(s1==s2) {
//        				sum++;
//        			}
//        		}
//        		ans = Math.max(ans, sum);
//        	}
//        }
//        return ans;
//    }

    
//另一种解法.Hash表记录求解
//   public int maxPoints(int[][] points) {
//        int n = points.length;
//    	int res = 0;
//        for(int i=0;i<n;i++) {
//        	HashMap<String,Integer> map = new HashMap<>();
//        	int max = 0;//这里必须要设置为0，因为这是记录和points[i]结点的斜率相同的点的个数，这些点并不包含points[i]
//        	for(int j=i+1;j<n;j++) {
//        		int x1 = points[i][0],x2=points[j][0];
//        		int y1 = points[i][1],y2=points[j][1];
//        		int dX = x1-x2;
//        		int dY = y1-y2;
//        		int k = gsc(dX,dY); //这里顺序别反了，因为分母不能为0；
//        		String key = (dX/k) +"_" + (dY/k);
//        		map.put(key,map.getOrDefault(key, 0)+1);
//        		max = Math.max(max, map.get(key));//这里是对当前斜率的出现的次数+1
//        	}
//        	res = Math.max(res, max+1);//这里max+1是加上自己本身。
//        }
//        return res;
//    }
//	
//	public int gsc(int a,int b) {
//		return b==0 ? a : gsc(b,a%b);
//	}
    public int maxPoints(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            dfs(x1, y1, i + 1, points, 0, true, 1, false);
        }
        return res;
    }
    public void dfs(int x1, int y1, int start, int[][] points, double k, boolean flag, int sum, boolean isV) {
        res = Math.max(res, sum);

        for (int i = start; i < points.length; i++) {
            int x2 = points[i][0];
            int y2 = points[i][1];
            double slope=0;

            if (x1 != x2) {
                if (isV) {
                    continue;
                }
                slope = (double)(y2 - y1) / (double)(x2 - x1);//注意这里需要将int类型强转为double类型，否则斜率永远为整数.
            } else {
                if (!isV && !flag) {//如果之前不垂直，并且不是第一次。
                    continue;
                } else {
                    dfs(x2, y2, i + 1, points, slope, false, sum + 1, true);
                }
            }

            if (slope == k || flag) {
                dfs(x2, y2, i + 1, points, slope, false, sum + 1, isV);
            }
        }
    }
}
