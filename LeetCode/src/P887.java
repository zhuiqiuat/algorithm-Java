public class P887 {

    private static int[][] dp = new int[10001][101];

    static{
        for(int i = 1;i <= 10000;i++){
            for(int j = 1;j <= 100;j++){
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] + 1;
            }
        }
    };

    public int superEggDrop(int k, int n) {
        for(int i = 0;i <= 10000;i++){
            if(dp[i][k] >= n){
                return i;
            }
        }
        return -1;
    }

}
