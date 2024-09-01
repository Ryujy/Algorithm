import java.io.*;
import java.util.*;

// [BOJ] 로봇청소기
public class Main {
    public static int[] dr = {-1, 0, 1, 0}; // 북동남서(상우하좌) - 반시계 : idx--
    public static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // r
        int M = Integer.parseInt(st.nextToken()); // c
        int[][] room = new int[N][M];
        int[] robot = new int[3];

        st = new StringTokenizer(br.readLine()); // 로봇의 r, c, d
        for (int i=0; i<3; i++){
            robot[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input room

        int cnt = 0;
        int cr = robot[0];
        int cc = robot[1];
        L: while(true){
            // 1. 현재 칸 청소
            if (room[cr][cc] == 0){
//                System.out.printf("청소 : %d, r : %d, c: %d \n", room[cr][cc], cr, cc);
                room[cr][cc] = 2; // 1 - 벽  2- 청소한 칸
                cnt ++;
            }

//            System.out.println(cnt);
//            for (int i=0; i<N; i++){
//                for (int j=0; j<M; j++){
//                    System.out.print(room[i][j] + " ");
//                }
//                System.out.println();
//            }


            // 주변 4칸 중 청소할 칸 확인
            for (int d=0; d<4; d++){ // 현재 방향에서 반시계로 확인
                int rd = (robot[2] + 3) % 4;
                int nr = cr + dr[rd];
                int nc = cc + dc[rd];
                if (room[nr][nc] == 0){ // 3. 청소할 칸 O -> 반시계 90도 회전, 전진
                    robot[2] = rd;
                    cr = nr;
                    cc = nc;
                    break; // 1.로 돌아감
                } else if (d < 3){
//                    System.out.printf("d : %d \n", d);
                    robot[2] = rd;
                } else { // 2. 4칸 중 청소할 칸 X -> 후진
                    robot[2] = rd; /* 틀린 부분 : 반시계로 확인하며 돌아갔는데 후진할 땐 확인 전의 방향키로 후진해야함. */
//                    System.out.printf("후진 (%d,%d) \n", cr, cc);
//                    System.out.printf("후진 : %d \n", robot[2]);
                    nr = cr - dr[robot[2]];
                    nc = cc - dc[robot[2]];
//                    System.out.printf("후진 (%d,%d) \n", nr, nc);
                    if (room[nr][nc] == 1){ //후진 불가능
                        break L;
                    }
                    cr = nr;
                    cc = nc;
                    break ;
                }
            }
        }
        System.out.println(cnt);
        
    }

}