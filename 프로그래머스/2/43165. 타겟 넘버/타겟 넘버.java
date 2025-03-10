import java.util.*;

class Solution {
    static int target, answer;
    public int solution(int[] numbers, int t) {
        target = t;
        answer = 0;
        dfs(numbers, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int idx, int sum){
        if (idx == numbers.length && sum == target){
            answer++;
        }
        if (idx >= numbers.length) return;
        
        int cur = numbers[idx];
        dfs(numbers, idx+1, sum-cur);
        dfs(numbers, idx+1, sum+cur);
    }
}