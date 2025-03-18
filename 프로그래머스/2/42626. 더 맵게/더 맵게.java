import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {       
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s:scoville){
            pq.offer(s);
        }

        int cnt = 0;
        int min = pq.peek();
        while(min < K){
            int firstMin = pq.poll();
            if(pq.isEmpty()) return -1;
            int secondMin = pq.poll();

            min = firstMin + (secondMin*2);
            cnt++;
            pq.offer(min);
            
            min = pq.peek();
        }
        
        return cnt;
    }
}