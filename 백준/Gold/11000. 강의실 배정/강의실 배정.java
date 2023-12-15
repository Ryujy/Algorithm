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

// 백준 - 강의실 배정
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
		Data[] time = new Data[N];
		List<Data> list = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			time[i] = new Data(s, e);
		}
		
		Arrays.sort(time, new Comparator<Data>() {

			@Override
			public int compare(Data o1, Data o2) {
				if(o1.start == o2.start) {
					return o1.end - o2.end;
				}
				return o1.start - o2.start;
			}
			
		});
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(time[0].end);
		for (int i=1; i<N; i++) {
			if (time[i].start >= pq.peek()) {
				pq.poll();
				pq.offer(time[i].end);
			} else {
				pq.offer(time[i].end);
			}
		}
		
		System.out.println(pq.size());
	}
}