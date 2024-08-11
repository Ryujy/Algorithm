import java.io.*;
import java.util.*;
// SWEA_4193. 수영대회 결승전 24.08.11
public class Solution {
    public static int[][] map;
    public static boolean[][] v;
    public static int N;
    public static int[] dr = {-1, 1, 0, 0}; //상하좌우
    public static int[] dc = {0, 0, -1, 1};
    public static class Data{
        int r;
        int c;
        int time;
        public Data(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<T+1; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            v = new boolean[N][N];
            for (int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // map input
            // 시작위치 input
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 도착위치 input
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            map[c][d] = -1;

            // BFS 시작
            int min = bfs(a, b);
            System.out.println("#" + tc + " " + min);
        }// tc
    }

    public static int bfs(int a, int b){
        ArrayDeque<Data> q = new ArrayDeque<>();
        q.offer(new Data(a, b, 0));
        while (!q.isEmpty()){
            Data data = q.poll();
            int r = data.r;
            int c = data.c;
            int t = data.time;
            v[r][c] = true;
            if (map[r][c] == -1){ //도착
                return t;
            }

            for (int d=0; d<4; d++){
                int nr = r + dr[d];
                int nc = c + dc[d];
                // 범위 췤!!!!!!!!!!!
                if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1){
                    continue;
                }
                // 장애물 췤!
                if (map[nr][nc] != 1 && !v[nr][nc]) {
                    if (map[nr][nc] == 2 && (t+1) % 3 != 0){ // 다시 볼 소용돌이
                        q.offer(new Data(r, c, t+1));
                    } else {
                        q.offer(new Data(nr, nc, t+1));
                    }
                }
            }
        }
        return -1;
    }

}