import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 백준 - 계단오르기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 계단의 개수
		int[] stair = new int[301];
		int[] score = new int[301];
		
		for (int i=1; i<N+1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		score[1] = stair[1];
		score[2] = stair[1] + stair[2];
		score[3] = Math.max(stair[1], stair[2]) + stair[3];
		
		for (int i=4; i<N+1; i++) {
			score[i] = Math.max(score[i-3] + stair[i-1], score[i-2]) + stair[i];
		}
		
		System.out.println(score[N]);
	}
}