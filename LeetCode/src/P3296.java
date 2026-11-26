public class P3296 {

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long l = 1;
        long r = (long) 1e16;
        long ans = r;
        while(l <= r){
            long m = (l + r) / 2;
            long rem = 0;
            for(int x : workerTimes){
                long tmp = m / x;
                rem += (long) (Math.sqrt(0.25 + 2 * tmp) - 0.5);
            }
            /*

            1 + x / 2 * x = y
            x ^ 2 * 1 / 2 + x / 2 - y = 0

            -1/2 + sqrt(1/4 + 2y);

             */
            if(rem >= mountainHeight){
                ans = m;
                r = m - 1;
            }else{
                l = m + 1;
            }
        }
        return ans;
    }

}
