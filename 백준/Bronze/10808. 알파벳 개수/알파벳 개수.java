import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	static int[] alpha, word;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		alpha = new int[26];
		
		for (int i=0; i<str.length(); i++) {
			int idx = (str.charAt(i) - 0) - 97;
			alpha[idx] += 1;
		}
		for (int i=0; i<26; i++) {
			System.out.print(alpha[i]+" ");
		}
		
	}
}
