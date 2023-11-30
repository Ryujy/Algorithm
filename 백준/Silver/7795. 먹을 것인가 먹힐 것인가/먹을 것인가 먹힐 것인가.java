import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 - 빈도 정렬
public class Main {
	
	static int N, M;
	static ArrayList<Integer> A, B;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //A의 수
			M = Integer.parseInt(st.nextToken()); //B의 수
			A = new ArrayList<>();
			B = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				A.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				B.add(Integer.parseInt(st.nextToken()));
			}
			
			// A는 자기보다 작은 B를 잡아먹음.
			// A, B모두 내림차순
			// B의 최소보다 작은 A는 연결 0
			Collections.sort(A); // 1 1 3 7 8
			Collections.sort(B); // 1 3 6
			
			int cnt = 0;
			int min = B.get(0);
			int max = B.get(M-1);
			for (int i=0; i<N; i++) { //A
				int a = A.get(i);
				if (a <= min) continue;
				if (a > max) {
					cnt += M;
					continue;
				}
				for (int j=0; j<M; j++) { //B
					int b = B.get(j);
					if (a <= b) break; // 못 먹음
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}