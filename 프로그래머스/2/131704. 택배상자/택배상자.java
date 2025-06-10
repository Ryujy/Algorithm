import java.util.*;

class Solution {
    // 택배 기사님이 미리 알려준 순서에 맞게 영재가 택배상자를 실어야 합니다.
    public int solution(int[] order) {
        int answer = 0;
        // 보조 컨테이너 벨트 = Stack
        int cnt = 0;
        Stack<Integer> sub = new Stack<>();
        for (int j=1; j<=order.length; j++){ // 본 컨테이너 1,2,3,4,5..
            sub.add(j); // 보조 컨테이너로 보내기
            
            while(!sub.isEmpty() && order[cnt] == sub.peek()){
                cnt++;
                answer++;
                sub.pop();
            } 
        }
        
        return answer;
    }
}