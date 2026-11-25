import java.util.*;

public class P3934 {
    public class StringHash {

        private final int base = 1000003;

        private final int MOD = 1000000007;
    /*
        131	教科书、蓝书	最经典，也最容易被针对
        13331	老 OI 讲义	> 全 ASCII，安全
        233 / 313 / 101	各种野生代码	小，但对 26 字母够用
        10007 / 99991 / 1000003	大质数 base	分散性好
        1313131	CF 上常见
        911382323 / 972663749	随机大 base 近似	接近 1e9 量级
     */

        private final long[] pre;
        private final long[] preBase;

        public StringHash(int[] l){
            pre = new long[l.length + 1];
            preBase = new long[l.length + 1];
            preBase[0] = 1;
            for(int i = 0; i < l.length; i++){
                pre[i + 1] = (pre[i] * base + l[i]) % MOD;
                preBase[i + 1] = (preBase[i] * base) % MOD;
            }
        }

        public StringHash(List<Integer> l){
            pre = new long[l.size() + 1];
            preBase = new long[l.size() + 1];
            preBase[0] = 1;
            for(int i = 0; i < l.size(); i++){
                pre[i + 1] = (pre[i] * base + l.get(i)) % MOD;
                preBase[i + 1] = (preBase[i] * base) % MOD;
            }
        }

        public StringHash(String s){
            pre = new long[s.length() + 1];
            preBase = new long[s.length() + 1];
            preBase[0] = 1;
            for(int i = 0; i < s.length(); i++){
                pre[i + 1] = (pre[i] * base + s.charAt(i)) % MOD;
                preBase[i + 1] = (preBase[i] * base) % MOD;
            }
        }

        public long query(int l,int r){
            return (pre[r] - (pre[l - 1] * preBase[r - l + 1]) % MOD + MOD) % MOD;
        }
    }

    public int smallestUniqueSubarray(int[] nums) {
        StringHash stringHash = new StringHash(nums);
        int l = 1;
        int r = nums.length;
        int ans = 0;
        while(l <= r){
            int m = (l + r) >> 1;
            Map<Long,Integer> mp = new HashMap<>();
            int cnt = 0;
            for(int i = 1;i + m - 1 <= nums.length;i++){
                long hash = stringHash.query(i,i + m - 1);
                if(mp.containsKey(hash)){
                    mp.put(hash,mp.get(hash) + 1);
                }else{
                    mp.put(hash,1);
                }
            }
            for(Integer x : mp.values()){
                if(x == 1){
                    cnt++;
                }
            }
            if(cnt > 0){
                r = m - 1;
                ans = m;
            }else{
                l = m + 1;
            }
        }
        return ans;
    }
}
