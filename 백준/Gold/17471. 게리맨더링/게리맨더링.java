import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	static int N, res;
	static int[] population;
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 구역의 개수
		population = new int[N + 1]; // 1번구역~ N번 구역 인구
		adj = new int[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken()); // 인접 구역 개수
			for (int j = 0; j < m; j++) {
				int from = Integer.parseInt(st.nextToken());
				adj[i][from] = 1;
			}
		}
		int[] teams = new int[N + 1];
		
		res = Integer.MAX_VALUE;
		dfs(teams, 1);
		if (res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}
	}

	private static void dfs(int[] teams, int idx) {
		if (idx == N + 1) {
			if (check(teams, 0) && check(teams, 1)) {
				int min = doCount(teams);
				res = (res > min) ? min : res;
			}
			return;
		}

		// 0번 구역으로 선택
		teams[idx] = 0;
		dfs(teams, idx + 1);

		// 1번 구역으로 선택
		teams[idx] = 1;
		dfs(teams, idx + 1);

	}

	private static boolean check(int[] teams, int type) { // 연결되었는지 확인, 구역 두 개 확인
		boolean[] v = new boolean[N + 1];
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i < N + 1; i++) { // 시작 정점 찾아서 큐에 삽입
			if (teams[i] == type) {
				q.offer(i);
				v[i] = true; // 방문체크
				break; // 시작 정점 찾았으니까 끝
			}
		}
		if (q.isEmpty())
			return false; // 해당 타입의 구역 하나도 없음 => 지역 분리 안됨 -> 리턴

		while (!q.isEmpty()) { // 구역들이 연결되었는지 확인
			int cur = q.poll();

			for (int j = 1; j < N + 1; j++) {
				if (v[j])
					continue; // 방문한 구역 넘김

				if (teams[j] != type)
					continue; // cur과 다른 지역 -> 넘김

				if (adj[cur][j] == 0)
					continue; // 인접지역이 아님 -> 넘김

				q.offer(j);
				v[j] = true;
			}
		}

		for (int k = 1; k < N + 1; k++) {
			if (teams[k] != type)
				continue;
			if (!v[k])
				return false; // 같은 구역인데 방문하지 않았다 = 연결 X => false
		}

		return true;
	}

	private static int doCount(int[] teams) {
		int zero = 0;
		int one = 0;
		for (int i = 1; i < N + 1; i++) {
			if (teams[i] == 0) {
				zero += population[i];
			} else {
				one += population[i];
			}
		}
		return Math.abs(zero - one);
	}
}
