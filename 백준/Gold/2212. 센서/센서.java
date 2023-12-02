import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 - 센서
public class Main {
	
	static ArrayList<Integer> sen;
	static int[] diff;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 센서의 개수
		sen = new ArrayList<>();
		diff = new int[N-1];
		int K = Integer.parseInt(br.readLine()); // 집중국의 개수
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			sen.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(sen); //내림차순 정렬
		
		for (int i=0; i<N-1; i++) {
			diff[i] = sen.get(i+1) - sen.get(i);
		}
		Arrays.sort(diff);
		
		int min=0;
		for (int i=0; i< N-K; i++) {
			min += diff[i];
		}
		
		System.out.println(min);
	}
}