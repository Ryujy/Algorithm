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

	static int L,R,C;
	static char[][][] map;
	static int[] dr = {-1,1,0,0,0,0};
	static int[] dc = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,1,-1};
	static ArrayDeque<Data> q = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	
	static class Data{
		int r;
		int c;
		int z;
		int time;
		
		public Data(int z, int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.z = z;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[L][R][C];
			
			if (L == 0 && R == 0 && C == 0) {
				break;
			}
			
			q.clear();
			for (int i = 0; i<L; i++) {
				for (int j = 0; j<R+1; j++) {
					String str = br.readLine();
					if (str.equals("")) continue;
					for (int k = 0; k<C; k++) {
						map[i][j][k] = str.charAt(k);
						if (map[i][j][k] == 'S') {
							q.offer(new Data(i,j,k,0));
							map[i][j][k] = '#';
						}
					}
				}
			}
			
			bfs();
		}
		System.out.println(sb);
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Data cur = q.poll();
			int cz = cur.z;
			int cr = cur.r;
			int cc = cur.c;
			
			for (int d=0; d<6; d++) {
				int nz = cz + dz[d];
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if (isValid(nz, nr, nc)) {
					if (map[nz][nr][nc] == 'E') {
						sb.append("Escaped in ").append(cur.time+1)
						.append(" minute(s).").append('\n');
						return;
					}
					q.offer(new Data(nz, nr, nc, cur.time+1));
					map[nz][nr][nc] = '#';
				}
			}
		}
		sb.append("Trapped!").append('\n');
	}
	
	private static boolean isValid(int z, int r, int c) {
		if (z > -1 && z < L && r > -1 && r < R && c > -1 && c < C) {
			if (map[z][r][c] != '#') {
				return true;
			}
		}
		return false;
	}
}
