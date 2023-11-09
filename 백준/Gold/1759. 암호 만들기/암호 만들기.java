import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int L,C;
	static String[] alpha;
	static String[] pw;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		alpha = new String[C];
		pw = new String[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<C; i++) {
			alpha[i] = st.nextToken();
		}
		Arrays.sort(alpha);
		
		dfs(0,0);
		System.out.println(sb);
	}

	private static void dfs(int cnt, int start) {
		if (cnt == L) {
			int vowel = 0;
			int k = 0;
			for (String a : pw) {
				if ("aeiou".contains(a)) {
					vowel++;
				} else {
					k++;
				}
			}
			if (vowel > 0 && k >1) {
				for (String a : pw) {
					sb.append(a);
				}
				sb.append('\n');
			}
			return;
		}
		
		for (int i=start; i<C; i++) {
			pw[cnt] = alpha[i];
			dfs(cnt+1, i+1);
		}
	}
}
