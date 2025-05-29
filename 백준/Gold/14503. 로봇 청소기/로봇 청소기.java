import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Integer.*;
import static java.lang.Math.*;

class Main{ // 14503. 로봇 청소기

    static int n, m;
    static int size = 1;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 북,동,남,서
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r = parseInt(st.nextToken()); // 최초의 행
        int c = parseInt(st.nextToken()); // 최초의 열
        int d = parseInt(st.nextToken()); // 최초의 방향 북,동,남,서

        for (int i=0; i<n; i++){ // 1: 벽, 0: 청소X
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                map[i][j] = parseInt(st.nextToken());
            }
        } // map input

        // 로봇청소기가 청소하는 칸의 개수를 구하기
        clean(r, c, d);
        System.out.println(size);
    }

    static void clean(int r, int c, int d){
        // 1. 현재 칸이 청소되지 않은 경우,
        map[r][c] = -1; // 현재 칸을 청소한다.
        for (int i=0; i<4; i++){
            d = (d+3)%4; // 3-1. 반시계 방향 회전
            int nr = r + dr[d];
            int nc = c + dc[d];
             // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
            if (isValid(nr, nc) && map[nr][nc] == 0){
            // 3-2. 바라보는 방향의 앞쪽 칸 청소X면 전진
                size++;
                clean(nr, nc, d);
                return; // *****
            }
        }
        // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
        // 2-1. 바라보는 방향 유지,
        int bd = (d+2)%4;
        int br = r + dr[bd];
        int bc = c + dc[bd];
        if (isValid(br,bc) && map[br][bc] != 1){ // 후진 가능하면 후진
            clean(br, bc, d);
        }
    }

    static boolean isValid(int r, int c){
        return 0 < r && r < n-1 && 0 < c && c < m-1;
    }
}