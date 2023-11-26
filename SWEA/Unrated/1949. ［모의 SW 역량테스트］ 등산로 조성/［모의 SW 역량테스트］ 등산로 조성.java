import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution { //산악 구조 로봇
	
	static int N, K, max, len;
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
			
			int max = 0;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					int val = map[i][j] = Integer.parseInt(st.nextToken());
					max = (val > max)? val : max; // 가장 높은 봉우리의 높이 찾기
				}
			}// map end
			len = 0;
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (map[r][c] == max) { // 가장 높은 봉우리에서 시작
						v[r][c][1] = true;
						dfs(r, c, 1, 1);
						v[r][c][1] = false;
					}
				}
			}
			System.out.println("#"+tc+" "+len);
		}// tc end
	}
	
	private static void dfs(int r, int c, int depth, int k) { 
		// k -> 0:깎고 도착, 1: 안 깎고 도착
		// 기저조건
		if (map[r][c] < 1) {
			len = (len > depth)? len:depth;
			return;
		}
		
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
			} else {
				for (int i=1; i<K+1; i++) {
					if (map[nr][nc] - i < map[r][c]) {
						//깎아야 하므로 안 깎고 도착한 경우만 가능
						if(k == 1 && !v[nr][nc][k]) {
							v[nr][nc][k] = true;
							map[nr][nc] -= i;
							dfs(nr, nc, depth+1, 0);
							v[nr][nc][k] = false;
							map[nr][nc] += i;
						}
					} else {
						len = (len > depth)? len:depth;
						continue;
					}
				}
			}
		}
	}
	
}