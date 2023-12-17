import java.util.*;
import java.io.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Arrays.sort(tangerine);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int before = tangerine[0];
        int cnt = 0;
        for (int i : tangerine){
            if (before == i){
                cnt++;
            } else {
                before = i;
                pq.offer(cnt);
                cnt = 1;
            }
        }
        pq.offer(cnt);
    
        while(k > 0){
            k -= pq.poll();
            answer++;
        }
        return answer;
    }
}