import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, K, res;
	static boolean[] v = new boolean[100001];
	static int[] arr = new int[100001];
	static StringBuilder sb = new StringBuilder();
	
	static class Data{
		int cur; //현 위치
		int time; //시간
		
		public Data(int cur, int time) {
			this.cur = cur;
			this.time = time;
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Arrays.fill(arr, -1);
		arr[N] = K;
		arr[K] = K;
		bfs();
		
	}
	
	private static void bfs() {
		ArrayDeque<Data> q = new ArrayDeque<>();
		ArrayList<Integer> dist = new ArrayList<>();
		
		q.offer(new Data(N, 0));
		v[N] = true;
		
		while(!q.isEmpty()) {
			Data temp = q.poll();
			int n = temp.cur;
			
			if (n == K) {
				sb.append(temp.time).append('\n');
				
				
				while(true) {
					dist.add(K);
					
					if (K == N) {
						for (int i=dist.size()-1; i>-1; i--) {
							sb.append(dist.get(i)).append(" ");
						}
						System.out.println(sb);
						return;
					}
					
					K = arr[K];
				}
			}
			
			
			if (isValidate(temp.cur-1)) {
				q.offer(new Data(temp.cur-1, temp.time+1));
				v[temp.cur-1] = true;
				arr[temp.cur-1] = temp.cur;
			}
			if (isValidate(temp.cur+1)) {
				q.offer(new Data(temp.cur+1, temp.time+1));
				v[temp.cur+1] = true;
				arr[temp.cur+1] = temp.cur;
			}
			if(isValidate(temp.cur *2)) {
				q.offer(new Data(temp.cur *2, temp.time+1));
				v[temp.cur*2] = true;
				arr[temp.cur*2] = temp.cur;
			}
			
			
		}
	}
	
	private static boolean isValidate(int n) {
		if (n < 0 || n > 100000 || v[n]) {
			return false;
		}
		return true;
	}
}
