import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 - 2xN 타일링2
public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		
		arr[1] = 1;
		arr[2] = 3;
		
		for (int i=3; i<N+1; i++) {
			arr[i] = (arr[i-1] + (arr[i-2]*2)) % 10007;
		}
		
		System.out.println(arr[N]);
	}
}