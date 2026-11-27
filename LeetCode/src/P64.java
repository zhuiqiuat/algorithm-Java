public class P64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][1] = dp[1][0] = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                dp[i + 1][j + 1] = Math.min(dp[i][j + 1],dp[i + 1][j]) + grid[i][j];
            }
        }
        return dp[n][m];
    }
}
