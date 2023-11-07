import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
	
	static int[] ans; //정답 조합 저장 배열
	static int[] S;
	static int k;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			if (k == 0) break; 
			
			S = new int[k];
			ans = new int[6];
			for (int i=0; i<k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			combi(0, 0);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	// 배열 S는 k개의 수 => k개의 수에서 6개를 고른다. 자리 상관 X ->조합
	static void combi(int cnt, int start) {
		if (cnt == 6) { //6개의 숫자를 다 골랐다면 종료
			for (int i=0; i<6; i++) {
				sb.append(ans[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i=start; i<k; i++) {
			ans[cnt] = S[i];
			combi(cnt+1, i+1);
		}
	}
}
