import java.util.List;
import java.util.Scanner;

public class P9653 {
    static Scanner sc = new Scanner(System.in);

    static void solve(){
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n + 2];
        a[0] = a[n + 1] = -1;
        for(int i = 1;i <= n;i++){
            a[i] = sc.nextInt();
        }
        int cnt2 = 0;
        int cnt1 = 0;
        int last = 1;
        int ans = 0;
        for(int i = 1;i <= n + 1;i++){
            if(a[i] != a[i - 1]){
                ans++;
                cnt2 += (last - 1) / 2;
                if(last % 2 == 0){
                    cnt1++;
                }
                last = 1;
            }else{
                last++;
            }
        }
        ans--;
        if(m >= cnt2){
            ans += cnt2 * 2;
            m -= cnt2;
        }else{
            ans += m * 2;
            m = 0;
        }
        if(m >= cnt1){
            ans += cnt1;
        }else{
            ans += m;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for(int i = 0;i < t;i++){
            solve();
        }
    }
}
