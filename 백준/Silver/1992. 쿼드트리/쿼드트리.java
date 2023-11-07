import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		divide(N, 0, 0);
		System.out.println(sb);
	}
	static void divide(int size, int x, int y) {
		if (colorChk(size, x, y)) {
			sb.append(map[x][y]);
			return;
		}
		int newSize = size/2;
		
		sb.append("(");
		divide(newSize, x, y); // 1 왼위;
		divide(newSize, x, y+newSize); // 2 오위;
		divide(newSize, x+newSize, y); // 3 왼아;
		divide(newSize, x+newSize, y+newSize); // 4 오아;
		sb.append(")");
	}

	static boolean colorChk (int size, int x, int y) {
		// 영상 체크
		int color = map[x][y]; //시작 기준점 컬러 체크
		for (int i=x; i<x+size; i++) {
			for (int j=y; j<y+size; j++) {
				if (map[i][j] != color) return false;
			}
		}
		return true;
	}

}
