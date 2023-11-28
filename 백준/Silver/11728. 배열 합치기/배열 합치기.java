import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 - 배열 합치기
public class Main {
	
	static int N, M;
	static int[] A, B, C;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); //배열 A의 크기
		M = Integer.parseInt(st.nextToken()); //배열 B의 크기
		A = new int[N];
		B = new int[M];
		C = new int[N+M];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int j=0; j<M; j++) {
			B[j] = Integer.parseInt(st.nextToken());
		}
		
		// mergesort
		for (int a=0,b=0,c=0; c<N+M; c++) {
			if (b == M) C[c] = A[a++];
			else if (a == N) C[c] = B[b++];
			else if (A[a] <= B[b]) C[c] = A[a++];
			else if (A[a] > B[b]) C[c] = B[b++];
		}
		
		for (int i=0; i<N+M; i++) {
			sb.append(C[i]).append(" ");
		}
		System.out.print(sb);
	}
}
