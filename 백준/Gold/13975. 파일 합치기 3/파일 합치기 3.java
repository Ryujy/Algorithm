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
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 백준 - 파일 합치기 3
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc=0; tc<T; tc++) {
			long cnt = 0;
			int k = Integer.parseInt(br.readLine()); // 소설 장의 수
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i=0; i<k; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}
			
			while(!pq.isEmpty()) {
				if (pq.size() == 1) {
					pq.poll();
					break;
				}
				long tmp = 0;
				for (int i=0; i<2; i++) {
					tmp += pq.poll();
				}
				pq.offer(tmp);
				cnt += tmp;
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
		
}