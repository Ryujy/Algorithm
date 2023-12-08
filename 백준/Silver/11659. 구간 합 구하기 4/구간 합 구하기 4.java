import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int N; // 수의 개수
	static int T; // tc의 수
	static int[] nums; // N개의 수
	static int[] prefixSum; // 누적합 배열

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		nums = new int[N + 1];
		prefixSum = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			prefixSum[i] = prefixSum[i - 1] + nums[i];
		}
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			int sum = prefixSum[j] - prefixSum[i - 1];

			sb.append(sum).append("\n");
		}
		System.out.println(sb.toString());
	}

}
