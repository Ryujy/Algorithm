import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        
        while (!que.isEmpty()){    
            int[] cur = que.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            if (cr == n-1 && cc == m-1){
                return cur[2];
            }
            
            for (int d=0; d<4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                if (nr < 0 || nc < 0 || nr >= n || nc >= m || maps[nr][nc] == 0 || visited[nr][nc]) continue;
                que.offer(new int[] {nr, nc, cur[2]+1});
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
}