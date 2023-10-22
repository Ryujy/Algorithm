import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int ans = 0;
			int num = Integer.parseInt(st.nextToken());

			sb.append(divide(N, num, nums, 0, N - 1)).append('\n');
		}
		System.out.println(sb);
	}

	private static int divide(int N, int num, int[] nums, int low, int high) {
		// binarySearch
		while (low <= high) {
			int mid = (low + high) / 2;
			if (num == nums[mid]) {
				return 1;
			} else if (num < nums[mid]){
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return 0;
	}

}
