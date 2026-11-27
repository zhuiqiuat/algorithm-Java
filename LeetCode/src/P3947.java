import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class P3947 {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] cnt = new int[items.length + 1];
        for(int i = 0;i < items.length;i++){
            cnt[items[i][0]]++;
        }
        for(int i = 1;i <= items.length;i++){
            if(cnt[i] > 0){
                cnt[i]--;
            }
            for(int j = i * 2;j <= items.length;j += i){
                cnt[i] += cnt[j];
            }
        }
        int[] cnt2 = new int[items.length];
        for(int i = 0;i < items.length;i++){
            cnt2[i] = cnt[items[i][0]];
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<List<Integer>> pq2 = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.getFirst() - o2.getFirst();
            }
        });
        for(int i = 0;i < items.length;i++){
            if(cnt2[i] > 0){
                pq2.add(List.of(items[i][1],cnt2[i]));
            }else{
                pq1.add(items[i][1]);
            }
        }
        int ans = 0;
        while(!pq2.isEmpty()){
            int p1 = 1000000000;
            if(!pq1.isEmpty()){
                p1 = pq1.peek();
            }
            int p2 = pq2.peek().getFirst();
            if(p1 * 2 < p2){
                int tot = budget / p1;
                budget -= tot * p1;
                ans += tot;
                break;
            }else{
                int tot = budget / p2;
                int rem = Math.min(tot,pq2.peek().getLast());
                ans += rem * 2;
                budget -= rem * p2;
                if(rem == pq2.peek().getLast()){
                    pq1.add(pq2.poll().getFirst());
                }else{
                    break;
                }
            }
        }
        if(!pq1.isEmpty()){
            ans += budget / pq1.peek();
        }
        return ans;
    }
}
