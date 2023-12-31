import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 백준 - 회전 초밥
public class Main {
	
	static int N, d, k, c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 접시의 수
		d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
		k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
		c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
		
		int[] chobap = new int[N];
		
		for (int i=0; i<N; i++) {
			chobap[i] = Integer.parseInt(br.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		// 0번 그릇 부터 N-1번 그릇까지 반복
		for (int i=0; i<N; i++) {
			int[] eat = new int[d+1]; // 먹은 초밥의 종류 기록
			int cnt = 1;
			eat[c]++; // 쿠폰 기록
			for (int j=i; j<i+k; j++) { // k번 연속 먹는다.
				if (eat[chobap[j%N]] == 0) {// 해당 종류를 먹은 적이 없다.
					cnt++;
					eat[chobap[j%N]]++;
				}
			}
			
			max = max<cnt?cnt:max; //최댓값 갱신
		}
		
		System.out.println(max);
	}
		
}