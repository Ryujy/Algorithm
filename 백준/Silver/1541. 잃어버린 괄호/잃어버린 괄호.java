import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 - 잃어버린 괄호
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		ArrayList<Integer> minus = new ArrayList<>();
		
//		int sum = Integer.parseInt(st.nextToken());
		int sum = Integer.MAX_VALUE;
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			StringTokenizer st2 = new StringTokenizer(str, "+");
			int plus = 0;
			while(st2.hasMoreTokens()) {
				plus += Integer.parseInt(st2.nextToken());
			}
			
			if(sum == Integer.MAX_VALUE) {
				sum = plus;
			} else {
				sum -= plus;				
			}
		}
		
		System.out.println(sum);
		
		
	}
}