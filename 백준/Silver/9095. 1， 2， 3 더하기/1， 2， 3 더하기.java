import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 - 1,2,3 더하기_DP
public class Main {
	
	static int N;
	static int[] D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		D = new int[11];
		D[1] = 1;
		D[2] = 2;
		D[3] = 4;
		
		for (int k=4; k<11; k++) {
			D[k] = D[k-1] + D[k-2] + D[k-3];
		}
		for (int tc=1; tc<T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			
			System.out.println(D[N]);
			
			
		}
		
	}
}
