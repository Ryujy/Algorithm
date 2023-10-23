import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n, x;
	static int[] nums;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(nums);
		int start = 0;
		int end = n-1;
		int res = 0;
		
		while(start < end) {
			int sum = nums[start] + nums[end];
			if (sum < x) {
				start += 1;
			} else {
				if (sum == x) {
					res++;
				}
				end -= 1;
			}
		}
		
		System.out.println(res);
	}
}
