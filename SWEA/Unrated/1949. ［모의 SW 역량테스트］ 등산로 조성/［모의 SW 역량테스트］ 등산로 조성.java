import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution { //등산로
	
	static int N, K, top, max;
	static int[][] map;
	static boolean[][][] v;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			v = new boolean[N][N][2];
			
			top = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					int val = map[i][j] = Integer.parseInt(st.nextToken());
					top = (val > top)? val : top; // 가장 높은 봉우리의 높이 찾기
				}
			}// map end
			max = 0;
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (map[r][c] == top) { // 가장 높은 봉우리에서 시작
						v[r][c][1] = true;
						dfs(r, c, 1, 1);
						v[r][c][1] = false;
					}
				}
			}
			System.out.println("#"+tc+" "+max);
		}// tc end
	}
	
	private static void dfs(int r, int c, int depth, int k) { 
		// k -> 0:깎고 도착, 1: 안 깎고 도착
		// f : 최장 거리는 dfs 돌릴 때마다 depth로 max를 갱신해주는 것이 더 깔끔!!!
//		before >
//		if (map[r][c] < 1) {
//			len = (len > depth)? len:depth;
//			return;
//		}
		max = (max > depth)? max:depth;
		
		for (int d=0; d<4; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) {
				continue;
			}
			// 현재보다 낮은 곳으로만 전진
			if (map[nr][nc] < map[r][c]) { // 그냥 낮은 경우
				if (!v[nr][nc][k]) {
					v[nr][nc][k] = true;
					dfs(nr, nc, depth+1, k);
					v[nr][nc][k] = false;
				}
			} 
			if (map[nr][nc] - K < map[r][c]) { // f: 최대로 깎았을 때 전진 가능하면 진행하도록하고,
				int h = map[r][c] - (map[nr][nc] -1);
				for (int i= h; i<K+1; i++) { // f : 1 ~ K 모두 하지 말고 깎을 높이 최소부터! 예) 현재 6 -> 다음 8 이면 최소 -3 부터 전진 가능. => 3,4,5 로 진행.
					if (map[nr][nc] - i < map[r][c]) {
						if(k == 1 && !v[nr][nc][k]) { //깎아야 하므로 안 깎고 도착한 경우만 가능
							v[nr][nc][k] = true; // f : 깎을 수 있기 때문에 방문체크 필수!! 잘했음.
							map[nr][nc] -= i;
							dfs(nr, nc, depth+1, 0);
							v[nr][nc][k] = false;
							map[nr][nc] += i;
						}
					}
				}
			}

		}
	}
	
}