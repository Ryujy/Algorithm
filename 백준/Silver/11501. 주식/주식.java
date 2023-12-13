import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 - 주식
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine()); //날의 수
			long[] stock = new long[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			long max = stock[N-1];
			long sum = 0;
			for (int i=N-2; i>-1; i--) {
				if (stock[i] < max) { // 다음 날 보다 가격이 낮으면 매수 -> 판매
					sum += (max - stock[i]);
				} else {
					max = stock[i];
				}
			}
			
			sb.append(sum).append("\n");
		} // tc end
		
		System.out.println(sb);
		
	}
}