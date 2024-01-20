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

// 백준 - 카드 정렬하기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			pq.offer(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 0;
		while(!pq.isEmpty()) {
			if (pq.size() == 1) {
				break;
			}
			int tmp = 0;
			for (int i=0; i<2; i++) {
				tmp += pq.poll();
			}
			pq.offer(tmp);
			cnt += tmp;
		}
		System.out.println(cnt);
	}
		
}