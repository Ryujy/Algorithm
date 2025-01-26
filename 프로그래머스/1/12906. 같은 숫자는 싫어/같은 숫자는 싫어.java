import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayDeque<Integer> que = new ArrayDeque<>();
        
        for (int i=0; i<arr.length; i++){
            int value = arr[i];
            if(que.isEmpty() || que.peekLast() != value){
                que.addLast(value);
            }
        }
        
        answer = new int[que.size()];
        int i = 0;
        while(!que.isEmpty()){
            answer[i++] = que.pollFirst();
        }
        
        return answer;
    }
}