import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 - 선긋기
public class Main {
	
	static class Data{
		int start;
		int end;
		public Data(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Data> line = new ArrayList<>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			line.add(new Data(s, e));
		}
		
		line.sort(new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
		});
		
		PriorityQueue<Data> pq = new PriorityQueue<>();
		pq.offer(new Data(line.get(0).start, line.get(0).end));
		
		int sum = 0;
		for (int i=1; i<N; i++) {
			Data cur = pq.peek();
			if (line.get(i).start <= cur.end) { // 이전 선 길이에 포함.
				if (line.get(i).end > cur.end) { // 새로운 선이 이전 선 보다 end가 클 때만 end 변경
					pq.poll();
					pq.offer(new Data(cur.start, line.get(i).end));
				}
			} else { // 이전 선 길이를 벗어남.
				Data prev = pq.poll();
				sum += (prev.end - prev.start);
				pq.offer(new Data(line.get(i).start, line.get(i).end));
			}
		}
		Data prev = pq.poll();
		sum += (prev.end - prev.start);
		
		System.out.println(sum);
	}
}