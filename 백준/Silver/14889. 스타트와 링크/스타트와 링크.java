import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 스타트와 링크
public class Main {

	static int N, minP;
	static int[][] S; // 능력치
	static int[] teams;
	static int[] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 1~N 번 : 사람
		S = new int[N + 1][N + 1]; // 사람 조합별 능력치의 합

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 입력 end
		// 팀 나누기
		teams = new int[N / 2];
		v = new int[N + 1];
		minP = Integer.MAX_VALUE;
		divide(0, 1);
		System.out.println(minP);
	}

	private static void divide(int cnt, int start) {
		if (cnt == N / 2) {
			// 능력치 계산 -> 차이 계산
			int min = check();
			minP = (minP < min) ? minP : min;
			return;
		}

		for (int i = start; i < N + 1; i++) { // 팀 조합
			teams[cnt] = i;
			v[i] = 1;
			divide(cnt + 1, i + 1);
			v[i] = 0;
		}
	}

	private static int check() {
		int startSum = 0;
		int linkSum = 0;
		
		for (int i=1; i<N+1; i++) {
			for (int j=i; j<N+1; j++) {
				if(v[i]+v[j]>1) { //true
					startSum += (S[i][j] + S[j][i]);
				} else if (v[i]+v[j] == 0) {
					linkSum += (S[i][j] + S[j][i]);
				}
			}
		}
		return Math.abs(linkSum - startSum);
	}
}
