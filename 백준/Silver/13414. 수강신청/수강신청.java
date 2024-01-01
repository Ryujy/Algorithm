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

// 백준 - 수강 신청
public class Main {
	
	static int K, L;
	static class Data{
		String id;
		int idx;
		public Data(String id, int idx) {
			this.id = id;
			this.idx = idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		K = Integer.parseInt(st.nextToken()); //과목의 수강 가능 인원
		L = Integer.parseInt(st.nextToken()); //대기 목록의 길이
		
		HashMap<String, Integer> map = new HashMap<>();
		for (int i=0; i<L; i++) {
			String val = br.readLine();
			map.put(val, i);
		}
		ArrayList<Data> list = new ArrayList<>();
		for (Entry<String, Integer> e : map.entrySet()) {
			list.add(new Data(e.getKey(), e.getValue()));
		}
		Collections.sort(list, new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				return o1.idx - o2.idx;
			}
		});
		
		int cnt = 0;
		for (Data data : list) {
			if (cnt == K) break;
			sb.append(data.id).append("\n");
			cnt++;
		}
		
		System.out.println(sb);
	}
		
}