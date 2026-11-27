package Math;

public class FastPow {

    private static final long MOD = 1000000007;

    public static long pow(long a,long b){
        a %= MOD;
        long res = 1;
        while(b > 0){
            if((b & 1) == 1){
                res = (res * a) % MOD;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }

}
