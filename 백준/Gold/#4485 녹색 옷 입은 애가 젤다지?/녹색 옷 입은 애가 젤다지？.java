import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, minCost;
	static int [][] map;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1}; //상하좌우
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = 0;
		while(true) {
			tc++;
			N = Integer.parseInt(br.readLine());
			if (N == 0) {
				break;
			}
			map = new int[N][N];
			v = new boolean[N][N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minCost = Integer.MAX_VALUE;
			bfs();
			sb.append("Problem ").append(tc).append(": ").append(minCost);
			sb.append("\n");	
			
		}
//			System.out.println("Problem "+tc+": "+minCost);
		System.out.println(sb);
	}

	private static void bfs() {
		PriorityQueue<Data> pq = new PriorityQueue<>((Data o1, Data o2) ->{
			return o1.cost - o2.cost;
		});
		pq.offer(new Data(0,0,map[0][0]));
		v[0][0] = true;
		
		while(!pq.isEmpty()) {
			Data cur = pq.poll();
			v[cur.r][cur.c] = true;
			if (cur.r == N-1 && cur.c == N-1) {
				minCost = cur.cost;
				return;
			}
			
			for (int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				int cost = cur.cost;
				
				if (isValid(nr, nc) && !v[nr][nc]) {
					int plus = map[nr][nc];
					pq.offer(new Data(nr, nc, cost+plus));
				}
			}
		}
		
	}

	private static boolean isValid(int nr, int nc) {
		if (nr > -1 && nr < N && nc > -1 && nc < N) {
			return true;
		}
		return false;
	}
	
	static class Data{
		int r, c;
		int cost;
		public Data(int r, int c, int cost) {
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
	}
}
