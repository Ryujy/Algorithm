import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int M,N,K;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int total; // 영역 개수
	static int area;
	
	public static StringBuilder sb= new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // y
		N = Integer.parseInt(st.nextToken()); // x
		K = Integer.parseInt(st.nextToken()); //직사각형 개수
		
		map = new int[N][M];
		v = new boolean[N][M];
	
		
		for (int i=0; i<K; i++) { // 사각형 넓이 채우기
			st = new StringTokenizer(br.readLine());
			// 왼쪽 아래 꼭짓점
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			// 오른쪽 위 꼭짓점
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			// 영역 채우기 (왼쪽 위부터 시작)
			for (int j=lx; j<rx; j++) {
				for(int k=ly; k<ry; k++) {
					map[j][k] += 1;
				}
			}

		}
		
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 0 && !v[i][j]) {
					area = 0;
					v[i][j] = true;
					bfs(i,j);
					list.add(area);
					total++;
				}
			}
		}

		Collections.sort(list);
		
		System.out.println(total);
		for (int l : list) {
			System.out.print(l+" ");
		}
	}
	
	static void bfs(int x, int y) {
		area = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y}); //x좌표, y좌표, 영역 크기
		
		while(!q.isEmpty()) {
			int[] temp = q.poll();
			
			for (int d=0; d<4; d++) {
				int mx = temp[0] + dx[d];
				int my = temp[1] + dy[d];
				
				if (mx > -1 && mx < N && my > -1 && my < M) { // 범위 안
					if (map[mx][my] == 0 && !v[mx][my]) { // 
						q.offer(new int[] {mx, my});
						v[mx][my] = true;
						area++;
					}
				} else {
					continue;
				}
			} // end for
		}
		
	}

}