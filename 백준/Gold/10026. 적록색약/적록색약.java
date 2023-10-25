import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static char[][] map;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		v = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int area = 0; // 비적록 0
		int Rarea = 0; // 적록 1
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					v[i][j] = true;
					RGB(i, j); // 비적록
					area++;
				}
			}
		}
		v = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j]) {
					v[i][j] = true;
                    RB(i,j);
					Rarea++;
				}
			}
		}
		System.out.println(area + " " + Rarea);
	}

	public static void RGB(int r, int c) {
		char cur = map[r][c];

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];

				if (nr > -1 && nr < N && nc > -1 && nc < N && !v[nr][nc]) {
					if (map[nr][nc] == cur) {
						q.offer(new int[] { nr, nc });
						v[nr][nc] = true;
					}
				}
			}
		}

	}

	public static void RB(int r, int c) {
		char cur = map[r][c];

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = temp[0] + dr[d];
				int nc = temp[1] + dc[d];

				if (nr > -1 && nr < N && nc > -1 && nc < N && !v[nr][nc]) {
					if (cur == 'R' || cur == 'G') {
						if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
							q.offer(new int[] { nr, nc });
							v[nr][nc] = true;
						}
					} else {
						if (map[nr][nc] == cur) {
							q.offer(new int[] { nr, nc });
							v[nr][nc] = true;
						}
					}
				}
			}
		}

	}
}
