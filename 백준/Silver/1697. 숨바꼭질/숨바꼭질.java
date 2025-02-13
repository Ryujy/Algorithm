import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int N; //수빈이 위치
	static int K; // 동생 위치
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS();
		
	}
	
	public static void BFS() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		q.offer(new int[] {N,0}); //처음에 K 넣기
		while(!q.isEmpty()) {
			int[] e = q.poll(); //큐에서 뽑아오기
			int data = e[0];
			int depth = e[1];
			if (data == K) { // 동생한테 도달했으면 시간넘기고 종료
				System.out.println(depth);
				return;
			}
			// 방문한 곳 방문처리
			visited[data] = true;
			// 현재 좌표에서 갈 수 있는 곳 다 큐에 넣기
			if (valid(data-1)) {
				q.offer(new int[] {data-1,depth+1});
			}
			if (valid(data+1)) {
				q.offer(new int[] {data+1,depth+1});
			}
			if (valid(data*2)) {
				q.offer(new int[] {data*2,depth+1});
			}
			
		}
	}
	
	public static boolean valid(int n) {
		if (n < 0 || n > 100000 || visited[n]) {
			return false;
		}
		return true;
	}

}
