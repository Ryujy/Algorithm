import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution { // 보물상자 비밀번호
	
	static int N, K, R;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 중복 제거, 크기 내림차순 정렬 => TreeSet
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=1; tc<T+1; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //숫자의 개수
			R = N/4;
			K = Integer.parseInt(st.nextToken()); //크기 순서
			
			String str = br.readLine();
			str = str.concat(str);
			
			TreeSet<String> set = new TreeSet<>(Collections.reverseOrder()); //내림차순
			
			int begin=0;
			for (int r=0; r<R; r++) {
				// 수 생성
				for (int i=begin; i<N; i+=R) {
					set.add(str.substring(i, i+R));
				}
				begin++;
			}
			
			int k=0;
			for (String s: set) {
				if(++k == K) {
					System.out.println("#"+tc+" "+Integer.parseInt(s,16));
				}
			}
		}

	}

}
