import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] map, dis;
	static boolean[][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N;
	
	public static class Data{
		int r;
		int c;
		int time;
		
		public Data(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc < T+1; tc++) { //tc
			N = Integer.parseInt(br.readLine()); //수영장의 크기
			
			map = new int[N][N];
			dis = new int[N][N];
			v = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int C = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int time = bfs(A,B,C,D);
			System.out.println("#"+tc+" "+time);
			
		} // tc end
	}

	private static int bfs(int sr, int sc, int ar, int ac) {
		
		ArrayDeque<Data> q = new ArrayDeque<>();
		q.offer(new Data(sr,sc,0));
		v[sr][sc] = true;
		// dis[sr][sc] = -1;
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			v[cur.r][cur.c] = true;
			if (cur.r == ar && cur.c == ac) {
				return cur.time;
			}
			
			for (int d =0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				int nt = cur.time +1;
				
				if (nr > -1 && nr < N && nc > -1 && nc < N) {
					if (!v[nr][nc] && map[nr][nc] != 1) {
						if (map[nr][nc] == 2 && nt % 3 != 0) { //소용돌이
							q.offer(new Data(cur.r,cur.c,nt));
							continue;
						} else {
							q.offer(new Data(nr,nc,nt));
						}
					}
				}
			}
		}
		return -1;
		
	}
	
}
