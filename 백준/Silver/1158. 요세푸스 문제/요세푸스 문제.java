import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N; // 사람의 수
	static int K; // 순서대로 K번째 사람 제거
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		
		for (int i=1; i <= N; i++) { //큐에 1~N 넣기
			q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		int cnt = 1; // 몇 번재 사람인지 카운트
		int s = 0;
		
		while(!q.isEmpty()) { // 큐가 빌 때까지(=> 큐가 비어있지 않는 동안)
			if (cnt == K) {// k번째 사람을 제거 (큐에서 빼고 뒤에 삽입)
				cnt = 1; // 몇 번째인지 세던 것 초기화
				s = q.poll();
				if(q.isEmpty()) {
					sb.append(s); //마지막 사람은 , 안넣기 위함
					break;
				}
				sb.append(s).append(", "); //k번째 사람을 제거하고 반환할 답에 넣음
			} else {
				cnt++;
				q.offer(q.poll()); // K번째가 아니면 제거하고 뒤로 다시 삽입
			}
		}
		System.out.println("<"+sb.toString()+">");
	}

}
