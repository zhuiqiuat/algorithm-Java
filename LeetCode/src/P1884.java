public class P1884 {

    private static int[] dp = new int[1001];

    static {
        for(int i = 1;i <= 1000;i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1;j <= i;j++){
                dp[i] = Math.min(dp[i],Math.max(j,dp[i - j] + 1));
            }
        }
    };

    public int twoEggDrop(int n) {
        return dp[n];
    }

}
