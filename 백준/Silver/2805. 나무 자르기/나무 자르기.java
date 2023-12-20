import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 - 나무 자르기
public class Main {

	static int N, M, max;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tree = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(tree);
		
		long low = 0;
		long high = tree[N-1];
		long h = 0;
		while(low <= high) {
			long sum = 0;
			long mid = (high + low)/2;
			// sum 계산
			for (long t : tree) {
				if (t > mid) {
					sum += (t - mid);
				} else {
					continue;
				}
			}
			//적어도 M 미터
			if (sum >= M) { // M보다 크면 덜 잘라야 하므로 h를 높인다.
				low = mid + 1;
				if (mid >= h) {
					h = mid;
				}
			} else { //M보다 작으면 더 잘라야 하므로 h를 낮춘다.
				high = mid - 1;
			}
		}
		
		System.out.println(h);
		
	}
}