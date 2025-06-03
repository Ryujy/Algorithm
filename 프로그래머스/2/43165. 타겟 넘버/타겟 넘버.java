import java.util.*;

class Solution {
    static int answer, target;
    public int solution(int[] numbers, int target) {
        answer = 0;
        this.target = target;
        dfs(0, 0, numbers);
        return answer;
    }
    private static void dfs(int idx, int sum, int[] numbers){
        if(idx >= numbers.length){
            if (sum == target) answer++;
            return;
        }
        
        dfs(idx+1, sum+numbers[idx], numbers);
        dfs(idx+1, sum-numbers[idx], numbers);
    }
}