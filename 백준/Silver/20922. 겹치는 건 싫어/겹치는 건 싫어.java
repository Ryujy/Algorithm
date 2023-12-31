import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// 백준 - 회전 초밥
public class Main {
	
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int start = 0;
		int end = 0;
		int[] nums = new int[100001];
		while(end < arr.length) {
			while(end < arr.length && nums[arr[end]] + 1 <= K) {
				nums[arr[end]]++; // 개수 증가
				end++;
			}
			int len = end - start;
			max = max<len?len:max;
			nums[arr[start]]--;
			start++;
		}
		
		System.out.println(max);
	}
		
}