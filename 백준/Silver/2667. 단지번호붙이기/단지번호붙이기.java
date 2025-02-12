import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // BOJ_2667_단지번호붙이기

    static char[][] map;
    static boolean[][] visit;
    static int n;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine()); // 지도의 크기

        map = new char[n][n];
        visit = new boolean[n][n];

        for (int i=0; i<n; i++){
            String str = br.readLine();
            for (int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        } // map end

        ArrayList<Integer> areas = new ArrayList<>();

        int cnt = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                int area = 0;
                if (map[i][j] == '1' && !visit[i][j]){
                    area = bfs(i, j);
                    areas.add(area);
                    cnt++;
                }
            }
        }
        Collections.sort(areas);
        System.out.println(cnt);
        for (int a : areas){
            System.out.println(a);
        }
    }

    private static int bfs(int r, int c){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {r, c});
        visit[r][c] = true;

        int area = 0;
        while(!que.isEmpty()){
            int[] tmp = que.poll();
            area++;
            for (int d=0; d<4; d++){
                int nr = tmp[0] + dr[d];
                int nc = tmp[1] + dc[d];

                if(nr > -1 && nr < n && nc > -1 && nc < n && !visit[nr][nc]) {
                    if (map[nr][nc] == '0') continue;
                    que.offer(new int[] {nr, nc});
                    visit[nr][nc] = true;
                }
            }
        }
        return area;
    }
}