import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, S, ans;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		ans = 0;
		dfs(0, 0);
        if (S == 0) ans--;
		System.out.println(ans);
	}

	private static void dfs(int cnt, int sum) {
		if (cnt == N) {
			if (sum == S) {
				ans++;
			}
			return;
		}

		// 원소 포함 O
		dfs(cnt + 1, sum + nums[cnt]);
		// 포함 X
		dfs(cnt + 1, sum);
	}

}
