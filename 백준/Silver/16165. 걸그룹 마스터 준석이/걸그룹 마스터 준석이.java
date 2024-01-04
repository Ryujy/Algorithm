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
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

// 백준 - 걸그룹 마스터 준석이
public class Main {

	static int N, M;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());//걸그룹의 수
		M = Integer.parseInt(st.nextToken());//문제의 수
		
		HashMap<String, Object> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			String group = br.readLine();
			int cnt = Integer.parseInt(br.readLine());
			for (int j=0; j<cnt; j++) {
				map.put(br.readLine(), group);
			}
		}
		
		for (int k=0; k<M; k++) {
			String q = br.readLine();
			int type = Integer.parseInt(br.readLine());
			if (type == 0) { // 그룹명 -> 멤버 출력
				ArrayList<String> member = new ArrayList<>();
				for (Entry<String, Object> e : map.entrySet()) {
					if(e.getValue().equals(q)) {
						member.add(e.getKey());
					}
				}
				Collections.sort(member);
				for (String mem : member) {
					sb.append(mem).append("\n");
				}
			} else { // 멤버 -> 그룹명 출력
				sb.append(map.get(q)).append("\n");
			}
		}
		System.out.println(sb);
	}
		
}