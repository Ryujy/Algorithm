import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();
        
        long totOne = 0;
        long totTwo = 0;
        for (int i=0; i<queue1.length; i++){
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            totOne += queue1[i];
            totTwo += queue2[i];
        }
        long total = totOne + totTwo;
        long half = total / 2;
        int cnt = 0;
        while (totOne != half){
            if (q1.isEmpty() || q2.isEmpty() || cnt+1 > queue1.length*3){
                return -1;
            }
            
            if (totOne < half){
                int val = q2.pop();
                q1.offer(val);
                totOne += val;
                totTwo -= val;
            } else {
                int val = q1.pop();
                q2.offer(val);
                totOne -= val;
                totTwo -= val;
            }
            cnt++;
        }
        
        return cnt;
    }
}