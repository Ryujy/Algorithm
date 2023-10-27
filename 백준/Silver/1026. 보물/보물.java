import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static ArrayList<Integer> A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		A = new ArrayList<>();
		B = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(A);
		Collections.sort(B, Collections.reverseOrder());

		int ans = 0;
		for (int i=0; i<N; i++) {
			ans += A.get(i) * B.get(i);
		}
		System.out.println(ans);
	}
}
