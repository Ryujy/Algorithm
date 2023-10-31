import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	 
	/* 점원 N명 키 => H1, H2, ..., Hi
	 * 탑의 높이 == 탑을 구성하는 점원들 키의 합
	 * (조건) 탑의 높이가 B 이상일 때 선반 사용 가능.
	 * (결과) 조건에 맞는 탑 중에서 가장 낮은 탑(min) -> B의 높이와 min의 차이가 가장 작은 것
	 * => 탑 구성원의 순서 의미X, 중복X ==> 부분집합 + 백트래킹(조건)
	 */
	static int N,B,min;
	static int[] height; //점원 키 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			height = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int n = 0; n<N; n++) { //점원들의 키
				height[n] = Integer.parseInt(st.nextToken());
			}
			min = Integer.MAX_VALUE;
			recur(0,0);
			System.out.println("#"+tc+" "+(min - B));
		} //tc
	}
	
	// 점원 키 부분집합 구하기
	private static void recur(int cnt, int sumH) {//거친 점원의 수, 키의 합
		
		// 탑의 높이가 B이상일 경우에만 최소값 갱신
		if (sumH >= B) {
			min = (sumH > min)? min:sumH;
		}
		
		// 종료 조건 : cnt == N
		if (cnt == N) {
			return;
		}
		
		// 부분집합
		recur(cnt+1, sumH+height[cnt] ); //포함
		recur(cnt+1, sumH); //미포함
	}
}
