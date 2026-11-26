public class P3360 {
    public boolean canAliceWin(int n) {
        int now = 0;
        for(int i = 10;i >= 1;i--){
            if(n >= i){
                n -= i;
            }else{
                return now % 2 != 0;
            }
            now++;
        }
        return now % 2 != 0;
    }
}
