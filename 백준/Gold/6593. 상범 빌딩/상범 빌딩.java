import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // BOJ_6593_상범빌딩

    static char[][][] map;
    static boolean[][][] visited;
    static ArrayDeque<int[]> que = new ArrayDeque<>();
    static int[] dr = {1, -1, 0, 0, 0, 0}; //동서남북상하
    static int[] dc = {0, 0, 1, -1, 0, 0}; //동서남북상하
    static int[] dl = {0, 0, 0, 0, 1, -1}; //동서남북상하

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken()); // 층
            int R = Integer.parseInt(st.nextToken()); // 행
            int C = Integer.parseInt(st.nextToken()); // 열

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            que.clear();
            for (int i=0; i<L; i++){
                for (int j=0; j<R+1; j++){
                    String str = br.readLine();
                    if(str.equals("")) continue;
                    for (int k=0; k<C; k++){
                        char ch = str.charAt(k);
                        map[i][j][k] = ch;
                        if(ch == 'S'){
                            que.offer(new int[] {i, j, k});
                            visited[i][j][k] = true;
                        }
                    }
                }
            }

            int res = bfs(L, R, C);
            if (res == -1){
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in "+ res +" minute(s).");
            }
        }
    }

    public static int bfs(int L, int R, int C){

        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();

            for (int i=0; i<size; i++) {
                int[] cur = que.poll();
                if (map[cur[0]][cur[1]][cur[2]] == 'E') {
                    return time;
                }

                for (int d = 0; d < 6; d++) {
                    int nl = cur[0] + dl[d];
                    int nr = cur[1] + dr[d];
                    int nc = cur[2] + dc[d];

                    if (nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C) continue;
                    if (visited[nl][nr][nc] || map[nl][nr][nc] == '#') continue;
                    que.offer(new int[]{nl, nr, nc});
                    visited[nl][nr][nc] = true;
                }
            }
            time++;
        }
        return -1;
    }
}