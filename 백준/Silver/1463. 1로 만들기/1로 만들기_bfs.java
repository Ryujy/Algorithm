import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 백준 - 1로 만들기_BFS
public class Main {
	
	static int N;
	static boolean[] dist;
	static class Data{
		int n;
		int depth;
		public Data(int n, int depth) {
			this.n = n;
			this.depth = depth;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dist = new boolean[N+1];
		
		bfs();
	}
	
	private static void bfs() {
		ArrayDeque<Data> q = new ArrayDeque<>();
		
		q.offer(new Data(N, 0));
		dist[N] = true;
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			int n = cur.n;
			
			if (n == 1) {
				System.out.println(cur.depth);
				return;
			}
			
			if (n%3==0 && isValid(n%3)) {
				q.offer(new Data(n/3, cur.depth+1));
				dist[n/3]=true;
			}
			if (n%2==0 && isValid(n%2)) {
				q.offer(new Data(n/2, cur.depth+1));
				dist[n/2]=true;
			}
			if (isValid(n-1)) {
				q.offer(new Data(n-1, cur.depth+1));
				dist[n-1] = true;
			}
		}
	}
	
	private static boolean isValid(int n) {
		if (n < 0 || n > N || dist[n]) {
			return false;
		}
		return true;
	}
}
