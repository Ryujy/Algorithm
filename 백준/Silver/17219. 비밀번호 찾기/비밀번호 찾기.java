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

// 백준 - 비밀번호 찾기
public class Main {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); //저장된 사이트의 수
		M = Integer.parseInt(st.nextToken()); //비번 찾으려는 사이트의 수
		
		HashMap<String, String> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		for (int j=0; j<M; j++) {
			String site = br.readLine();
			sb.append(map.get(site)).append("\n");
		}
		
		System.out.println(sb);
	}
		
}