import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 - 1로 만들기_DP
public class Main {
	
	static int N;
	static int[] D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		D = new int[N+1];
		
		/* DP
		 1. 테이블 정의하기
		// D[i]=i를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값
		 2. 점화식 찾기
		// D[12] = ?
		 * 3으로 나누거나 -> D[12] = D[4] + 1
		 * 2로 나누거나 -> D[12] = D[6] + 1
		 * 1을 빼거나 -> D[12] = D[11] + 1
		 * => D[12] = min(D[4] + 1, D[6] + 1, D[11] + 1)
		 3. 초기값 정의하기
		 // D[1] = 0
		 // 점화식이 돌아가기 위해 어디까지 초기값을 정의해줘야 할 지 잘 생각.
		*/
		
		D[1] = 0;
		for (int k=2; k<N+1; k++) {
			D[k] = D[k-1]+1;
			if (k%3 == 0) D[k] = Math.min(D[k/3] +1, D[k]);
			if (k%2 == 0) D[k] = Math.min(D[k/2] +1, D[k]);
		}
		
		System.out.println(D[N]);
	}
}
