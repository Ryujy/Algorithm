import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main { // BOJ_6593_상범빌딩

    static int L, R, C;
    static char[][][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = parseInt(st.nextToken()); // 빌딩 층 수
            R = parseInt(st.nextToken()); // 빌딩 행
            C = parseInt(st.nextToken()); // 열
            if (L == 0 && R == 0 && C == 0) {
                System.out.println(sb);
                break;
            }
            map = new char[L][R][C];

            int startL = -1, startR = -1, startC = -1;

            for (int l=0; l<L; l++){
                for (int r=0; r<R; r++){
                    String str = br.readLine();
                    for (int c=0; c<C; c++){
                        char tmp = str.charAt(c);
                        map[l][r][c] = tmp;
                        if (tmp == 'S') { // 시작점
                            startL = l;
                            startR = r;
                            startC = c;
                        }
                    }
                }
                String str = br.readLine();
            } // map end

            bfs(startL, startR, startC, 0);
        }
    }

    private static void bfs(int l, int r, int c, int time){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[L][R][C];
        queue.add(new int[]{l, r, c, time});
        visited[l][r][c] = true;

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int cl = cur[0];
            int cr = cur[1];
            int cc = cur[2];
            int ct = cur[3];

            if (map[cl][cr][cc] == 'E'){
                sb.append("Escaped in ").append(ct).append(" minute(s).").append('\n');
                return;
            }

            for(int d=0; d<6; d++){
                int nl = cl + dl[d];
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if(nl >= 0 && nr >= 0 && nc >= 0 && nl < L && nr < R && nc < C
                        && !visited[nl][nr][nc] && map[nl][nr][nc] != '#'){
                    queue.add(new int[]{nl, nr, nc, ct + 1});
                    visited[nl][nr][nc] = true;
                }
            }
        }
        sb.append("Trapped!").append('\n');
    }
}