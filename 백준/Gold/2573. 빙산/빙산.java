import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	
	static int[][] map;
	static int[][] near;
	static boolean[][] visit;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M;
	static Queue<int[]> q;
	static int cnt, time; //빙산 개수 확인 , 시간

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//바다: 0, 
		//빙산의 높이는 바닷물에 많이 접해있는 부분에서 더 빨리 줄어들기 때문에,
		
		while (true) {
			//1.덩어리 개수 확인
			cnt = 0;
			visit = new boolean[N][M];
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					if (map[i][j] != 0 && !visit[i][j]) {
						bfs(i,j);
						cnt++;
					}

				}
			}

			
			if (cnt > 1) {
				System.out.println(time);
				break;
			}else if (cnt == 0) {
				time=0;
				System.out.println(time);
				break;
			}
			
			//2. 빙산 녹이기
			time++;
			near = new int[N][M];
			minus();
			
		}
		
	}
	
	//빙산 녹이기
	static void minus() {
		for (int i=0; i<N; i++) { // 줄어들 크기 확인 -> 저장
			for (int j=0; j<M; j++) {
				if(map[i][j] != 0) {
					int sea = 0;
					for (int d=0; d<4; d++) {
						int tx = i+dx[d];
						int ty = j+dy[d];
						
						if (map[tx][ty] == 0) sea++;
					}
					near[i][j] = sea;
				}
			}
		}
		
		// 녹이기
		for (int i=0; i<N; i++) { 
			for (int j=0; j<M; j++) {
				int m = map[i][j] - near[i][j];
				if (m < 0) { //음수
					map[i][j] = 0;
				} else {
					map[i][j] = m;
				}
			}
		}
		
	}
	
	// 빙산 덩어리 확인
	static void bfs(int x, int y) {
		
		q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();

			for (int i=0; i<4; i++) {
				int tx = temp[0]+dx[i];
				int ty = temp[1]+dy[i];
				if (!isPossible(tx, ty) || visit[tx][ty] || map[tx][ty] == 0) {
					continue;
				}
				q.offer(new int[] {tx, ty});
				visit[tx][ty] = true;
				
			}
		}

	}
	
	static boolean isPossible(int x, int y) {
		if (x > -1 && x < N && y > -1 && y < M) {
			return true;
		}
		return false;
	}

}
