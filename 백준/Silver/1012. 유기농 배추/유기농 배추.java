import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int M,N,K;
	static int[][] map;
	static boolean[][] visit;
	static int[] dx = {-1, 1, 0, 0}; 
	static int[] dy = {0, 0, -1, 1};
	static int cnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc < T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); //가로 x
			N = Integer.parseInt(st.nextToken()); //세로 y
			K = Integer.parseInt(st.nextToken()); // 배추 위치 개수
			
			map = new int[N][M];
			visit = new boolean[N][M];
			
			for (int k=0; k<K; k++) { //배추 위치 기록
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken()); //M
				int x = Integer.parseInt(st.nextToken()); //N
				
				map[x][y] = 1;
			}
			
			cnt = 0;
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}// end tc
	}
	
	static void bfs(int sx, int sy) {
		Queue<int[]> q = new ArrayDeque<>();
		
		q.offer(new int[] {sx, sy});
		visit[sx][sy] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for (int i=0; i<4; i++) {
				int nx = temp[0]+dx[i];
				int ny = temp[1]+dy[i];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) { //맵 안에서
					if (map[nx][ny] == 1 && !visit[nx][ny]) { //배추라면
						q.offer(new int[] {nx, ny});
						visit[nx][ny] = true;
					}
				}
			}
		}
	}

}
