import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main { // 스타트와 링크
	
	static int N, min;
	static int[][] syn;
	static int[] team;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 사람 수
		syn = new int[N][N];
		team = new int[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				syn[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		team[0] = 1;
		combi(1,1);
		System.out.println(min);
	}
	
	private static void combi(int cnt, int start) {
		if (cnt == N/2) {
			int diff = getDiff();
			min = (min < diff)?min:diff;
		}
		
		for (int i=start; i<N; i++) {
			team[i] = 1; //A팀
			combi(cnt+1, i+1);
			team[i] = 0; //B팀
		}
	}
	
	private static int getDiff() {
		int a = 0;
		int b = 0;
		for (int i=0; i<N; i++) {
			for (int j=i; j<N; j++) {
				if (team[i]+team[j] > 1) {
					a += syn[i][j] + syn[j][i];
				}
				else if (team[i]+team[j] == 0) {
					b += syn[i][j] + syn[j][i];
				}
			}
		}
		return Math.abs(a-b);
	}
}
