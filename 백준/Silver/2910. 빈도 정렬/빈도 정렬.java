import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 백준 - 빈도 정렬
public class Main {
	
	static int N, C;
	static ArrayList<Integer> num;
	static ArrayList<Data> list;
	static class Data{
		int num;
		int cnt;
		int idx;
		public Data(int num, int cnt, int idx) {
			this.num = num;
			this.cnt = cnt;
			this.idx = idx;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		num = new ArrayList<>();
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int val = Integer.parseInt(st.nextToken());
			
			if (num.contains(val)) {
				for (Data cur: list) {
					if (cur.num == val) {
						cur.cnt++;
					}
				}
			} else {
				num.add(val);
				list.add(new Data(val, 1, i));
			}
		}
		
		Collections.sort(list, (Data o1, Data o2) -> {
			if (o1.cnt == o2.cnt) {
				return o1.idx - o2.idx; // 오름차순
			}
			return o2.cnt - o1.cnt; // 내림차순
		});
			
		for (Data cur:list) {
			for (int i=0; i<cur.cnt; i++) {
				System.out.print(cur.num + " ");
			}
		}
		
		
		
}
}