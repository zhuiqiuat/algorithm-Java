import java.util.ArrayList;
import java.util.List;

public class P3946 {
    public int maximumSaleItems(int[][] items, int budget) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < items.length;i++){
            int cnt = 0;
            for(int j = 0;j < items.length;j++){
                if(items[j][0] % items[i][0] == 0){
                    cnt++;
                }
            }
            list.add(cnt);
        }
        int[][] dp = new int[items.length + 1][budget + 1];
        for(int i = 0;i < items.length;i++){
            for(int j = 0;j <= budget;j++){
                if(j + items[i][1] <= budget){
                    dp[i + 1][j + items[i][1]] = Math.max(dp[i + 1][j] + 1,dp[i][j] + list.get(i));
                }
                dp[i + 1][j] = Math.max(dp[i + 1][j],dp[i][j]);
            }
        }
        return dp[items.length][budget];
    }
}
