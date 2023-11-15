import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

	static int N, minLen, maxCnt;
	static int[][] map, copy;
	static ArrayList<Core> list;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Core {
		int r;
		int c;

		public Core(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine().trim());

			map = new int[N][N];
			copy = new int[N][N];
			list = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) { // 0 :빈 칸, 1 :core
					int val = map[i][j] = Integer.parseInt(st.nextToken());
					if (val == 1) { // core 인 경우에 list에 저장
						if (i == 0 || i == N-1 || j == 0 || j == N-1) {
							continue;
						}
						list.add(new Core(i, j));
					}
				}
			} // map end
			maxCnt = 0;
			minLen = Integer.MAX_VALUE;
			dfs(0, 0);
			
			System.out.println("#"+tc+" "+minLen);

		} // tc end
	}

	private static void dfs(int idx, int cnt) { // 코어 idx, 코어 선택 갯수
		if (idx == list.size()) {
			int len = getCount(); //연결된 랜선 개수
			if (maxCnt < cnt) { // ****************************** 내가 선택한 코어가 더 클 때 갱신해야지
				maxCnt = cnt;
				minLen = len;
			} else if (maxCnt == cnt) {
				minLen = (minLen < len)?minLen:len;
			}
			return;
		}
		
		// 연결 - 상하좌우
		for (int d=0; d<4; d++) {
			if (isAvailable(idx, d)) { //연결 가능한가 확인
				connected(idx, d, 2); // 코어 idx, 연결 방향 , 채울 숫자
				dfs(idx+1, cnt+1);
				connected(idx, d, 0); //원복
			} 
		}
		
		// 연결 X
		dfs(idx+1, cnt);

	}
	
	private static boolean isAvailable(int idx, int dir) { // 코어 idx, 연결 방향
		Core cur = list.get(idx);
		int nr = cur.r;
		int nc = cur.c;
		
		while(true) { // 진행 방향에 다른 코어 or 전선 없는가
			nr += dr[dir];
			nc += dc[dir];  // **************************** 숨은그림찾기 주의
			
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) { //벽 만나면 연결 가능   ************** 부등호 방향 잘 보기
				return true;
			}
			
			if (map[nr][nc] == 0) continue; // 빈칸이면 계속
			if (map[nr][nc] == 1 || map[nr][nc] == 2) return false; //다른 코어 혹은 전선이면 연결 불가능
		}
	}
	
	private static void connected(int idx, int dir, int m) { // 코어 idx, 연결 방향 , 채울 숫자
		Core cur = list.get(idx);
		int nr = cur.r;
		int nc = cur.c;
		
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) { //벽 만나면 연결 완료      ************** 부등호 방향 잘 보기
				return;
			}
			
			map[nr][nc] = m;  // ****************************** 인자를 받았으면 잘 사용하거라...
		}
	}
	
	private static int getCount() {
		int cnt = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 2) cnt++;
			}
		}
		return cnt;
	}
}
