import java.io.*;
import java.util.*;

public class Main {
	static int N, S;
	static int result = 100001;
	static int sum = 0;
	static int start = 0;
	static int end = 0;
	static int nums[];

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

		while (true) {
			if (sum >= S) {
				sum -= nums[start];
				result = Math.min(result, end - start);
				start++;
			} else if (end == N) {
				break;
			} else {
				sum += nums[end++];
			}
		}

		if (result == 100001)
			System.out.println(0);
		else
			System.out.println(result);

	}

}