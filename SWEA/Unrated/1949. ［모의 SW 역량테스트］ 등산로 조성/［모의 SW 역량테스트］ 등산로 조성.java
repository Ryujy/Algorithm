import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K, max;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] v;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 최대한 긴 등산로 => DFS
		// 지형의 높이 -> 진행 방향 조건 있음
		// 한 곳을 깎아서 갈 수 있음
		// 가장 높은 봉우리 -> 내리막길 && 최장 거리 이므로 최소 차이나도록 감. 즉, 최대 K만큼 깎을 수 있지만 최소로 깎는 것이 좋음.
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1; tc<T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 길이
			map = new int[N][N];
			v = new boolean[N][N];
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			int top = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int val = map[i][j] = Integer.parseInt(st.nextToken());
					top = (top > val)?top:val; //가장 높은 봉우리 찾기
				}
			}
			
			max = 0;
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == top) {
						makeRoad(i, j, 1, false);
					}
				}
			}
			System.out.println("#"+tc+" "+max);
			
		}// tc end

	}
	
	private static void makeRoad(int r, int c, int depth, boolean isShaved) {
		max = (max>depth)?max:depth;
		
		v[r][c] = true; //방문체크
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];  // 오타 조심...ㅠㅠ **********************************
			
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1 || v[nr][nc]) continue;
			if (map[nr][nc] < map[r][c]) {
				makeRoad(nr, nc, depth+1, isShaved);
			} else if (!isShaved && map[nr][nc] - K < map[r][c] ) { // if로 해야함. 각자 다른 경우이므로 *********
				int temp = map[nr][nc];
				map[nr][nc] = map[r][c] - 1;
				makeRoad(nr, nc, depth+1, true);
				map[nr][nc] = temp; //복구
			}
		}
		
		v[r][c] = false; //복구
	}
}
