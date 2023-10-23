/* Arrays.sort 와 Collections.sort 의 시간복잡도 차이
둘의 시간복잡도 평균은 O(nlon(n))
하지만 Arrays.sort의 최악이 O(n^2) 이므로 Collections.sort가 좋은 듯!
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static StringBuilder sb = new StringBuilder();
	static int n, x;
	static int[] time;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		time = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time);
		int sum = 0;
		int total = 0;
		for (int i=0; i<n; i++) {
			sum += time[i];
			total += sum;
		}
		System.out.println(total);
		
	}
}
