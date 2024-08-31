import java.util.*;
class Solution { // 3. 잃어버린 강아지
    public int solution(int[][] board){
        int answer = 0;
        int[] dr = {-1, 0, 1, 0}; // 상 우 하 좌
        int[] dc = {0, 1, 0, -1};

        // 현수, 강아지 위치 각각 찾기
        int[] hs = {0, 0, 0}; // 현수 r, c, d(방향키)
        int[] dog = {0, 0, 0}; // 강아지 r, c, d(방향키)

        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (board[i][j] == 2){
                    hs[0] = i;
                    hs[1] = j;
                }
                if (board[i][j] == 3) {
                    dog[0] = i;
                    dog[1] = j;
                }
            }
        }
        int cnt = 0;
        while(cnt < 10000){
            cnt++;
            // 강아지 이동
            int nr = dog[0] + dr[dog[2]];
            int nc = dog[1] + dc[dog[2]];

            if(nr < 0 || nr >= 10 || nc < 0 || nc >= 10 || board[nr][nc] == 1){
                dog[2] = (dog[2] + 1) % 4;
            } else {
                /* 이렇게 할 필요 없이 강아지 좌표 값이랑 현수 좌표 값 비교하면 됨.
                board[dog[0]][dog[1]] = 0;
                board[nr][nc] = 3;
                */
                dog[0] = nr;
                dog[1] = nc;
            }

            // 현수 이동
            nr = hs[0] + dr[hs[2]];
            nc = hs[1] + dc[hs[2]];

            if(nr < 0 || nr >= 10 || nc < 0 || nc >= 10 || board[nr][nc] == 1){
                hs[2] = (hs[2] + 1) % 4;
                /* case2 틀린 이유
                * continue; // continue 하면 강아지 좌표 값 비교를 못함.
                * */
            } else {
                hs[0] = nr;
                hs[1] = nc;
            }
            if (hs[0] == dog[0] && hs[1] == dog[1]){ // 강아지 찾음
                answer = cnt;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
