public class P746 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 2];
        for(int i = 2;i <= n + 1;i++){
            dp[i] = Math.min(cost[i - 2] + dp[i - 1], (i - 3 >= 0 ? cost[i - 3] : 0) + dp[i - 2]);
        }
        return dp[n + 1];
    }
}
