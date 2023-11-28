import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K, R;
	static String[] arr;
	static ArrayList<Integer> res;
	static Set<Integer> set;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //숫자의 개수
			K = Integer.parseInt(st.nextToken()); //크기 순서
			R = N/4; // 한 변에 들어가는 숫자의 개수
			
			String str = br.readLine();
			
			arr = new String[N];
			set = new HashSet<>();
			for (int i=0; i<N; i++) {
				String s = String.valueOf(str.charAt(i));
				arr[i] = s;
			}
			
			for (int j =0; j<R; j++) { // 회전 수
				for (int i=0; i<4; i++) { // 4개의 변 -> 숫자 생성
					String hex = "";
					for (int r=0; r<R; r++) {
						hex += arr[ i * R + r];
					}
//					System.out.println(hex + ": "+Integer.parseInt(hex, 16));
					set.add(Integer.parseInt(hex, 16));
				}
				rotate();
			}
			
			res = new ArrayList<>();
			Iterator<Integer> iter = set.iterator();
			while(iter.hasNext()) {
				res.add(iter.next());
			}
			Collections.sort(res,Collections.reverseOrder());
			
			System.out.println("#"+tc+" "+res.get(K-1));
			
		}
	}
	
	private static void rotate() {
		String temp = arr[N-1]; //마지막 16진수
		for (int i=1; i<N; i++) {
			arr[N-i] = arr[N-(i+1)];
		}
		arr[0] = temp;
	}
}
