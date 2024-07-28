import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 치즈
public class Main {
	
	static int N,M; //세로,가로
	static int[][] map;
	static int[][] chk;
	static boolean[][] v;
	static int size, one;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //세로 행
		M = Integer.parseInt(st.nextToken()); //가로 열
		
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

			}
		}
		
		int time = 0;
		while(true) { // 치즈가 없어질 때까지
			if (!check()) { //치즈가 없으면
				break;
			}
			chk = new int[N][M];
			v = new boolean[N][M];
			size = 0;
			bfs(0,0);
			time++;

		}
		
		
		System.out.println(time);
//		System.out.println(size);
		// 0이 빈칸 1이 치즈
		// 공기와 접촉된 칸은 한 시간이 지나면 녹아 없어진다.
		// 치즈가 모두 녹아 없어지는 데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수
	}
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void bfs(int r, int c) { 
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {r,c});
		v[r][c] = true;//방문체크
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for (int d=0; d<4; d++) {
				int tr = temp[0] + dr[d];
				int tc = temp[1] + dc[d];
				
				if (tr > -1 && tr < N && tc > -1 && tc < M) {
					if (map[tr][tc] == 0 && !v[tr][tc]) { //공기
						q.offer(new int[] {tr, tc});
						v[tr][tc] = true;
					} else if (map[tr][tc] == 1) { // 공기 근처 치즈
							chk[tr][tc] += 1; // 겉에 녹일 치즈 부분 체크
					}
				}
			}
		}
		
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (chk[i][j] > 1) { //겉에 치즈 부분
					size++;
					map[i][j] = 0; // 원래 맵에서 치즈 녹이기
				}
			}
		}
		
		
	}
	
	static boolean check() { // 맵에 1이 있는지 확인하는 함수
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if(map[i][j] == 1) { // 맵에 1이 하나라도 있으면
					return true;
				}
			}
		}
		return false;
	}
	

}
