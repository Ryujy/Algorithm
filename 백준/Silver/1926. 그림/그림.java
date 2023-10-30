import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int maxSize;
	static int[][] map;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static class Data{
		int r;
		int c;
		
		public Data(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); //세로
		m = Integer.parseInt(st.nextToken()); //가로 
		
		map = new int[n][m];
		v = new boolean[n][m];
		for (int i=0; i<n; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 그림의 개수, 넓이
		maxSize = 0;
		int cnt = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] == 1 && !v[i][j]) {
					bfs(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxSize);
	}
	
	static void bfs(int r, int c) {
		int size = 0;
		ArrayDeque<Data> q = new ArrayDeque<>();
		
		q.offer(new Data(r, c));
		v[r][c] = true;
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			size++;
			
			for (int d=0; d<4; d++) {
				int nr = cur.r + dr[d];
				int nc = cur.c + dc[d];
				
				if (nr > -1 && nr < n && nc > -1 && nc < m) {
					if (!v[nr][nc] && map[nr][nc] == 1) {
						q.offer(new Data(nr, nc));
						v[nr][nc] = true;
					}
				}
			}
		}
		maxSize = (maxSize > size)?maxSize:size;
	}
}
