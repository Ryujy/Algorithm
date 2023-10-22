import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken()); // 인쇄 순서 궁금한 문서의 큐에서의 위치
			
			Queue<int[]> q = new ArrayDeque<int[]>();
			int[] pchk = new int[10]; //우선순위 체크 배열
			st = new StringTokenizer(br.readLine());
			for (int i=0; i < N; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				q.offer(new int[] {tmp,i});
				pchk[tmp]++;
			}
			
			
			int cnt = 0;
			L: while (!q.isEmpty()) {
				int[] pp = q.poll();
				for (int i= pp[0]+1; i < 10; i++) { // ***숫자 클수록 우선순위 높음
					if (pchk[i] > 0) {
						q.offer(pp);
						continue L;
					}
				}
				if (pp[1] == M) {
					cnt++;
					sb.append(cnt).append("\n");
					break;
				}
				pchk[pp[0]]--;
				cnt++;
			}
			
		}
		System.out.println(sb);
	}

}
