import java.util.*;
class Solution { //사다리타기
    public char[] solution(int n, int[][] ladder){
        char[] answer = new char[n];

        // answer에 알파벳 담기
        for (int i=0; i<n; i++){
            // 알파벳 담으려면 아르키 숫자 로 해야할 듯
            answer[i] = (char)('A' + i);
        }

        // 가로줄 탐색 ladder의 length만큼
        for (int l=0; l<ladder.length; l++){ // 가로줄 탐색
            for (int s=0; s< ladder[l].length; s++){ // 가로 막대 탐색
                int v = ladder[l][s];
                char tmp = answer[v-1];
                answer[v-1] = answer[v];
                answer[v] = tmp;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}}))); // 학생수, 사다리 정보
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
