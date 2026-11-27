public class P50 {

    private static final long MOD = 1000000007;

    public static double pow(double a,long b){
        a %= MOD;
        double res = 1;
        while(b > 0){
            if((b & 1) == 1){
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

    public double myPow(double x, int n) {
        double ans = pow(x, Math.abs((long) n));
        if(n < 0){
            ans = 1 / ans;
        }
        return ans;
    }
}
