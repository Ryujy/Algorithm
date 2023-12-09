import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 - 계단오르기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N+1];
		int[] P = new int[N+1];
		int[] dp = new int[N+2]; //N일 째부터 일한 값 중 최대 이익
		
		for (int i=1; i<N+1; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
			
		}
		
		for (int i=N; i>0; i--) {
			if (i + T[i] > N+1) { //일 마감날자 초과, 일 못함
				dp[i] = dp[i+1];
			} else { // 일 가능
				dp[i] = Math.max(dp[i+1], P[i]+dp[i+T[i]]);
			}
		}
		
		System.out.println(dp[1]);
	}
}