import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N,ans;
	static int[][] box;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayDeque<data> q = new ArrayDeque<>();
	
	static class data{
		int r;
		int c;
		int day;
		public data(int r, int c, int day) {
			super();
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		v = new boolean[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if (box[i][j] == 1) {
					q.offer(new data(i,j,0));
					v[i][j] = true; //방문체크
				}
			}
		}
		
		ans = -1;
		bfs();
//		for (int i=0; i<N; i++) {
//			for (int j=0; j<M; j++) {
//				if(box[i][j] == 1 && !v[i][j]) {
//					bfs(i,j);
//				}
//			}
//		}
		
		L: for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					ans = -1;
					break L;
				}
			}
		}
		System.out.println(ans);

	}

	private static void bfs() {
		while(!q.isEmpty()) {
			data cur = q.poll();
			ans = cur.day;
			for (int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if (nr > -1 && nr < N && nc > -1 && nc < M) {
					if (!v[nr][nc] && box[nr][nc] == 0) {
						int day = cur.day + 1;
						box[nr][nc] = 1;
						q.offer(new data(nr, nc, day));
						v[nr][nc] = true;
					}
				}
			}
			
		}
		
	}
}
