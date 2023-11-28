import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution { // 숫자만들기

	static int N, min, max;
	static int[] oper = new int[4]; // 연산자
	static int[] num, perm; // 숫자

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc < T + 1; tc++) {
			N = Integer.parseInt(br.readLine()); // 숫자의 개수
			num = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}

			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			perm = new int[N - 1];
			make(0);
			System.out.println("#" + tc + " " + (max - min));

		} // tc end

	}

	private static void make(int cnt) {
		if (cnt == N - 1) { // 마지막 연산자까지 다 뽑았다면
			// 1. 수식계산
			int res = getResult();
			// 2. 최대, 최소 비교
			min = (min < res) ? min : res;
			max = (max > res) ? max : res;
			return;
		}

		for (int i = 0; i < 4; ++i) { // 순열
			if (oper[i] == 0)
				continue;

			oper[i]--; // 해당 연산자의 개수 줄임
			perm[cnt] = i; // 연산자의 인덱스로 저장
			make(cnt + 1);
			oper[i]++; // 해당 연산자 개수 돌려놓음
		}
	}

	private static int getResult() {
		int sum = num[0];
		for (int i = 1; i < N; i++) {
			switch (perm[i - 1]) {
			case 0:
				sum += num[i];
				break;
			case 1:
				sum -= num[i];
				break;
			case 2:
				sum *= num[i];
				break;
			case 3:
				sum /= num[i];
				break;
			}
		}
		return sum;
	}

}