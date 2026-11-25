import java.util.Scanner;

public class P1564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        int[] a = new int[n + 1];
        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
        }
        for(int i = 1;i <= n;i++){
            int now = 0;
            for(int j = i - 1;j >= 0;j--){
                now += a[j + 1] == 1 ? 1 : -1;
                if(Math.abs(now) <= m || Math.abs(now) == i - j){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        System.out.println(dp[n]);
    }
}
