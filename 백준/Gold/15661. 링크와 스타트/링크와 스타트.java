import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 - 링크와 스타트 골드5
public class Main {

	static int N, min;
	static int[][] power;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		power = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				power[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		int[] team = new int[N];
		divide(team, 0);
		System.out.println(min);
	}

	private static void divide(int[] team, int n) {
		if (n > N - 1) {
			int res = cal(team);
			min = (res < min) ? res : min;
//			for (int i : team) {
//				System.out.print(i + ",");
//			}
//			System.out.println("res : " + res);
			return;
		}

		// n번이 링크 팀에 속한다.
		team[n] = 1;
		divide(team, n + 1);
		// n번이 링크 팀에 속하지 않는다. (=스타트팀에 속한다.)
		team[n] = 0;
		divide(team, n + 1);
	}

	private static int cal(int[] team) {
		int link = 0;
		int start = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j=i+1; j<N; j++) {
				if (team[i] + team[j] > 1) { // 링크 팀
					link += power[i][j] + power[j][i];
				}else if (team[i] + team[j] == 0) { // 스타트 팀
					start += power[i][j] + power[j][i];
				}
			}
		}
//		System.out.println("link : "+link+" start: "+start);
		return Math.abs(link - start);
	}
}