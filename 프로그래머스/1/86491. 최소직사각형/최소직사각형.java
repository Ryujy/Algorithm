import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int row = Integer.MIN_VALUE;
        int col = Integer.MIN_VALUE;
        
        for (int[] size : sizes){
            row = Math.max(row, Math.max(size[0], size[1]));
            col = Math.max(col, Math.min(size[0], size[1]));
        }
        answer = row * col;
        return answer;
    }
}