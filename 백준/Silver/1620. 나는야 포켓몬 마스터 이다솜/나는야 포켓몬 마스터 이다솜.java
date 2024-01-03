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
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		HashMap<Object, Object> map = new HashMap<>();
		
		for (int i=1; i<N+1; i++) {
			String name = br.readLine();
			map.put(name, i);
			map.put(String.valueOf(i), name);
		}
		
		for (int j=0; j<M; j++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
		
}