import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 - 용액
public class Main {

	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 용액의 수
		
		long[] liquid = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		long before = Math.abs(liquid[left] + liquid[right]);
		long ans1 = liquid[left];
		long ans2 = liquid[right];
		
		while(left < right) {
			long cur = liquid[left] + liquid[right];
			if (before > Math.abs(cur)) {
				ans1 = liquid[left];
				ans2 = liquid[right];
				before = Math.abs(cur);
			}
			
			if (cur <= 0) {
				left++;
			} else {
				right--;
			}
		}
		
		System.out.println(ans1 + " " +ans2);
		
	}
}