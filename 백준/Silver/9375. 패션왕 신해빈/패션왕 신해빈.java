import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;

// 백준 - 포켓몬 마스터
public class Main {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine()); // testcase
		
		for (int tc = 0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int cnt = n;
			
			HashMap<String, Integer> map = new HashMap<>();
			for (int i=0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken();
				String kind = st.nextToken();
				if (map.containsKey(kind)) {
					map.put(kind, map.get(kind)+1);
				}else {
					map.put(kind, 1);
				}
			}
			
			int result = 1;
			for (int val : map.values()) {
				result *= (val+1);
			}
			sb.append(result -1).append("\n");
		}
		System.out.println(sb);
	}
		
}