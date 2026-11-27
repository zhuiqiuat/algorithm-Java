public class P740 {
    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[10001];
        for(int x : nums){
            cnt[x]++;
        }
        int[] dp = new int[10001];
        dp[1] = cnt[1];
        int ans = 0;
        int pre = 0;
        for(int i = 2;i <= 10000;i++){
            pre = Math.max(pre,dp[i - 2]);
            dp[i] = pre + i * cnt[i];
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}
