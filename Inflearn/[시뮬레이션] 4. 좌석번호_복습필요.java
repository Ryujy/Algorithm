import java.util.*;
class Solution {  // 4. 좌석 번호
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];
        if(c * r < k){
            return new int[] {0,0};
        }
        int[][] seat = new int[c][r];
        int[] dr = {0, 1, 0, -1}; // 우 하 좌 상
        int[] dc = {1, 0, -1, 0};
        int d = 0;
        int cr = 0, cc = 0, cnt = 1;

        while(cnt < k) {
            // 좌석 배치
            int nr = cr + dr[d];
            int nc = cc + dc[d];

            if (nr < 0 || nr >= c || nc < 0 || nc >= r || seat[nr][nc] != 0){
                d = (d+1) % 4;
                continue;
            }
            seat[cr][cc] = cnt;
            cnt++;
            cr = nr;
            cc = nc;
        }
        answer[0] = cr + 1;
        answer[1] = cc + 1;

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
