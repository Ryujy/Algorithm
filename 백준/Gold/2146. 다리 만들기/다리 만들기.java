import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int[][] map;
    static int n;
    static int min=Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        map = new int[n][n];

        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                map[i][j] = parseInt(st.nextToken());
            }
        }

        int num = 2;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] == 1){
                    numbering(i, j, num++);
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (map[i][j] > 1){
                    bfs(i, j, map[i][j]);
                }
            }
        }
        System.out.println(min);
    }

    static void bfs(int r, int c, int number){
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c, 0});
        visited[r][c] = true;

        while(!queue.isEmpty()) {
            int[] tmp = queue.poll();
            int cr=tmp[0];
            int cc=tmp[1];
            int count=tmp[2];
            
            if(map[cr][cc]!=0&&map[cr][cc]!=number)
                min=Math.min(min,count-1);
            if(count>min)
                return;

            for(int i=0;i<4;i++) {

                int nr=cr+dr[i];
                int nc=cc+dc[i];
                if(nr<0||nc<0||nr>=map.length||nc>=map.length)
                    continue;
                if(map[nr][nc]==number)
                    continue;
                if(visited[nr][nc]) continue;

                queue.add(new int[] {nr,nc,count+1});
                visited[nr][nc]=true;
            }
        }
    }

    static void numbering(int r, int c, int num){
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;
        map[r][c] = num;

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            for (int d=0; d<4; d++) {
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];
                if (nr < 0 || nc < 0 || nr > n-1 || nc > n-1 || visited[nr][nc] || map[nr][nc] != 1) continue;

                map[nr][nc] = num;
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
            }
        }
    }
}
