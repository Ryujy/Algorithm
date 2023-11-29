import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution { 
	
	static int N, min;
	static int[][] syn;
	static int[] res;  // 조합 결과 
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		// 식재료의 조합 -> 식재료 궁합 차이 (A팀, B팀)
		// 1. 경우의 수를 출력 X -> 차이를 출력하므로 어떤 팀에 어떤 식재료 중요X
		// 2. 궁합 더할 때 syn[i][j]와 syn[j][i] 한 번에 계산 따라서 더욱 안 중요.
		
		for (int tc=1; tc<T+1; tc++) {
			N = Integer.parseInt(br.readLine());
			syn = new int[N][N];
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					syn[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			res = new int[N];
			res[0] = 1; // 첫 번째 식재료 선택한 채로 조합 ㄱㄱ
			combi(1, 1);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	private static void combi(int cnt, int start) {
		if (cnt == N/2) {
			int diff = getDiff();
			min = (min<diff)?min:diff;
			return;
		}
		
		for (int i=start; i<N; i++) {
			res[i] = 1; // cnt 번째 식재료 A음식
			combi(cnt+1, i+1);
			res[i] = 0; // cnt 번째 식재료 B음식
		}
	}
	
	private static int getDiff() {
		int A = 0;
		int B = 0;
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) { // i부터 시작하지 않아서 결과 값이 이상했음 !! **********************
				if (res[i] + res[j] > 1) { // A 재료
					A += syn[i][j] + syn[j][i];
				}
				if (res[i] + res[j] == 0) { //B 재료
					B += syn[i][j] + syn[j][i];
				}
			}
		}
		return Math.abs(A-B);
	}
}