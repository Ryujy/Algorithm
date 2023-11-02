import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] oriMap;
	static int[][][] zeroMap;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static StringBuilder sb = new StringBuilder();

	static class Data {
		int r;
		int c;
		int time;
		int bomb; // 부순 여부 0 : 안부숨 1: 부순

		public Data(int r, int c, int time, int bomb) {
			this.r = r;
			this.c = c;
			this.time = time;
			this.bomb = bomb;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		oriMap = new int[N][M];
		zeroMap = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				oriMap[i][j] = str.charAt(j) - '0';
			}
		}

		bfs();
	}

	private static void bfs() {

		ArrayDeque<Data> q = new ArrayDeque<>();

		q.offer(new Data(0, 0, 1, 0));
		zeroMap[0][0][0] = 1; // 방문체크

		while (!q.isEmpty()) {
			Data zero = q.poll();

			if (zero.r == N - 1 && zero.c == M - 1) { // 도착
				System.out.println(zero.time);
				return;
			}

			for (int d = 0; d < 4; d++) {
				int nr = zero.r + dr[d];
				int nc = zero.c + dc[d];

//				System.out.println(nr + "," + nc);

				if (nr < 0 || nr > N - 1 || nc < 0 || nc > M - 1) {
					continue;
				}
				if (oriMap[nr][nc] == 1) { // 벽
					if (zero.bomb == 1)
						continue;
					else { // 벽을 안 부숨.
						if (zeroMap[nr][nc][0] == 1)
							continue;
						q.offer(new Data(nr, nc, zero.time + 1, 1));
						zeroMap[nr][nc][1] = 1;
					}
				} else { // 벽X
					if (zero.bomb == 0 && zeroMap[nr][nc][0] == 1)
						continue; // 벽 안부심
					if (zero.bomb == 1 && zeroMap[nr][nc][1] == 1)
						continue;
					q.offer(new Data(nr, nc, zero.time + 1, zero.bomb));
					zeroMap[nr][nc][zero.bomb] = 1;
				}

			}
		}
		System.out.println(-1);
	}
}
