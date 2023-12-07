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
		
		int T = Integer.parseInt(br.readLine());
		
		long[] p = new long[101];
		
		p[1] = 1;
		p[2] = 1;
		p[3] = 1;
		p[4] = 2;
		p[5] = 2;
		
		for (int i=6; i<101; i++) {
			p[i] = p[i-1] + p[i-5];
		}
		
		for (int tc = 0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(p[N]).append("\n");
		}
		System.out.println(sb);
	}
}