import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;

import static java.lang.Integer.parseInt;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    static ArrayList<int[]> mirror = new ArrayList<>();
    static int[] start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        start = new int[2];
        end = new int[2];
        int cnt = 0;

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<n; j++){
                char tmp = str.charAt(j);
                map[i][j] = tmp;
                if (tmp == '#') { // 문
                    if (cnt == 1){
                        end[0] = i;
                        end[1] = j;
                    } else {
                        start[0] = i;
                        start[1] = j;
                        cnt++;
                    }
                } else if (tmp == '!'){ // 거울 설치 가능
                    mirror.add(new int[]{i, j});
                }
            }
        } // map end
        bfs(n, start[0], start[1]);
    }

    static void bfs(int n, int r, int c) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[3], b[3]));
        boolean[][][] visited = new boolean[n][n][4];

        for (int d=0; d<4; d++){
            queue.add(new int[]{r, c, d, 0}); // 시작점 기준 4방향
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int dir = cur[2];
            int cnt = cur[3];

            visited[cr][cc][dir] = true;

            if(cr == end[0] && cc == end[1]){
                System.out.println(cnt);
                return;
            }

            int nr = cr + dr[dir];
            int nc = cc + dc[dir];

            if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc][dir] && map[nr][nc] != '*') {
                if (map[nr][nc] == '!') { // 거울 설치 가능
                    // 시계 방향
                    int ndir = (dir + 3) % 4;
                    queue.add(new int[]{nr, nc, ndir,  cnt+1});

                    // 반시계
                    ndir = (dir + 1) % 4;
                    queue.add(new int[]{nr, nc, ndir, cnt + 1});
                }

                // 설치하지 않는 경우
                queue.add(new int[]{nr, nc, dir, cnt});
            }
        }

    }
}
