import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, K, res;
	static boolean[] v = new boolean[100001];
	
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
		
		bfs();
		
	}
	
	private static void bfs() {
		ArrayDeque<Data> q = new ArrayDeque<>();
		
		q.offer(new Data(N, 0));
		
		while(!q.isEmpty()) {
			Data temp = q.poll();
			int n = temp.cur;
			v[n] = true;
			if (n == K) {
				System.out.println(temp.time);
				return;
			}
			
			if(isValidate(temp.cur *2)) {
				q.offerFirst(new Data(temp.cur *2, temp.time));
			}
			if (isValidate(temp.cur-1)) {
				q.offer(new Data(temp.cur-1, temp.time+1));
			}
			if (isValidate(temp.cur+1)) {
				q.offer(new Data(temp.cur+1, temp.time+1));
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
