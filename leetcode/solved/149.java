
class Solution {
    int res = 0;

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
