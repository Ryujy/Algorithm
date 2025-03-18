import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {       
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s:scoville){
            pq.offer(s);
        }

        int cnt = 0;
        while(pq.peek() < K && pq.size() > 1){
            int firstMin = pq.poll();
            int secondMin = pq.poll();

            int mix = firstMin + (secondMin*2);
            cnt++;
            pq.offer(mix);
        }
        
        if (pq.size() <= 1 && pq.peek() < K){
            return -1;
        }
        
        return cnt;
    }
}