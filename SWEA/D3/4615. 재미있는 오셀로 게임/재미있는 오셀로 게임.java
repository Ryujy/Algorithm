import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

// SWEA_오셀로 게임
public class Solution {

	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우 왼위 오위 왼아 오아
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) { // tc
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken()); // 한 변의 길이 4,6,8
			M = Integer.parseInt(st.nextToken()); // 플레이어가 돌을 놓는 횟수

			map = new int[N][N];
			// 시작 세팅
			int sw = N / 2 - 1;
			int sb = N / 2;
			map[sw][sw] = map[sb][sb] = 2;
			map[sw][sb] = map[sb][sw] = 1;

			for (int i = 0; i < M; i++) { // 돌 놓기 입력
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int color = Integer.parseInt(st.nextToken()); // 1 -흑, 2 -백

				map[r][c] = color; // 돌 놓기
				// 가로, 세로, 대각선으로 색 변경할 돌 찾기

//				for (int x = 0; x < N; x++) {
//					for (int y = 0; y < N; y++) {
//						System.out.print(map[x][y]);
//					}
//					System.out.println();
//				}
//				System.out.println();
				
				change(r, c, color);

//				for (int x = 0; x < N; x++) {
//					for (int y = 0; y < N; y++) {
//						System.out.print(map[x][y]);
//					}
//					System.out.println();
//				}
//				System.out.println();

			} // 돌 놓기 입력 끝

			int w = 0;
			int b = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (map[x][y] == 1)
						b++;
					else if (map[x][y] == 2) {
						w++;
					}
				}
			}
			System.out.println("#" + tc + " " + b + " " + w);

		} // tc end

	}

	private static void change(int r, int c, int color) {
		// 가로, 세로는 상하좌우로 두 칸 너머 보고 한 칸 너머 색칠 // 대각선은? 마찬가지
		for (int d = 0; d < 8; d++) { // 상하좌우 대각선 -> 8방위 탐색
			int scope = 1;
			while (true) {
				int sr = r + dr[d]*scope;
				int sc = c + dc[d]*scope;
				
				if (sr < 0 || sr > N - 1 || sc < 0 || sc > N - 1) { // 벽 만나면 끝
					break;
				}
				if (map[sr][sc] == 0) { // 건너편에 같은 색 없으면 끝
					break;
				}
				
				if (map[sr][sc] == color) { // 오 같은 색 찾음
					for (int s=1; s<scope; s++) {
						int tr = r + dr[d]*s;
						int tc = c + dc[d]*s;
						
						map[tr][tc] = color;
					}
					break;
				}
				
				scope++;
			}
		}

	}

}
