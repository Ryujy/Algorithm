import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    
    static int N;
    static char[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N];
        
        for (int i=0; i<N; i++) {
        	String str = br.readLine();
            for (int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if(map[i][j] == '1' && !v[i][j]) {
                    int res = bfs(i,j);
                    list.add(res);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for (int l : list) {
        	sb.append(l).append('\n');
        }
        System.out.println(sb);
    }

    private static int bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {i, j});
        v[i][j] = true;
        int cnt = 0;
        
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            cnt += 1;
            
            for (int d=0; d<4; d++) {
            	int nr = temp[0] + dr[d];
                int nc = temp[1] + dc[d];
                
                if(nr > -1 && nr < N && nc > -1 && nc < N && !v[nr][nc]) {
                	if (map[nr][nc] == '1') {
                		q.offer(new int[] {nr, nc});
                		v[nr][nc] = true;
                	} else {
                		continue;
                	}
                }
            }
        }
        return cnt;
    }
}
