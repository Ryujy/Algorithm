import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 - 과자 나눠주기
public class Main {

	static int N, M, max;
	static int[] snack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); //조카의 수
		N = Integer.parseInt(st.nextToken()); // 과자의 수
		
		snack = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			snack[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(snack);
		
		long left = 1;
		long right = snack[N-1];
		long h = 0;
		
		while(left <= right) {
			long mid = (left + right) / 2;
			
			int cnt = 0;
			for (int i=0; i<N; i++) {
				cnt += snack[i] / mid;
			}
			
			if (cnt >= M) {
				if (h < mid) h = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(h);
		
	}
}