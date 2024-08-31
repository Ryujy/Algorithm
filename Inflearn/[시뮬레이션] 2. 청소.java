import java.util.*;
class Solution { //사다리타기
    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];
        int n = board.length;
        int[] dr = {0, 1, 0, -1};  // 우 하 좌 상
        int[] dc = {1, 0, -1, 0};
        int d = 0; // 방향키
        int cr = 0;
        int cc = 0;

        while(k!=0){
            /* try1) 틀리고 수정한 부분
            */
            int nr = cr + dr[d];
            int nc = cc + dc[d];
//            System.out.printf("n : %d ,%d \n", nr, nc);
            if (nr < 0 || nr >= n || nc < 0 || nc >= n || board[nr][nc] != 0) {
                d = (d + 1) % 4;
//                System.out.printf("d: %d \n", d);
                k--;
                continue;
            }
            /* try1) 틀리고 추가한 부분
                - while 시작 부분에 바로 좌표를 업데이트해버리면 
                if문으로 벽, 장애물을 거르더라도 해당 좌표로 이미 이동한 상황이 되어버림
                - 따라서 이동하기 전에 확인 후 이동하는 방식으로 변경
             */
            cr += dr[d];
            cc += dc[d];
//            System.out.printf("c : %d ,%d \n", cr, cc);
            k--;
        }
        answer[0] = cr;
        answer[1] = cc;
        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}
