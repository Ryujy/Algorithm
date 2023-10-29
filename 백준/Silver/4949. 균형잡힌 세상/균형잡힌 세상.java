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
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			Stack<String> stack = new Stack<>();
			String[] str = br.readLine().split("");
			if (str[0].equals(".")) {
				System.out.println(sb);
				break;
			}
			
			String ans = "yes";
			
			L: for (String s: str) {
				switch(s) {
				case "(":
					stack.push(s);
					break;
				case "[":
					stack.push(s);
					break;
				case ")":
					if (!stack.isEmpty()) {
						if (!stack.peek().equals("(")) {
							ans = "no";
							break L;
						} else {
							stack.pop();
							break;
						}
					} else {
						ans = "no";
						break L;
					}
				case "]":
					if (!stack.isEmpty()) {
						if (!stack.peek().equals("[")) {
							ans = "no";
							break L;
						} else {
							stack.pop();
							break;
						}
					} else {
						ans = "no";
						break L;
					}
				default :
					break;
				}
			}
			if (!stack.isEmpty()) {
				ans = "no";
			}
			sb.append(ans).append("\n");
		}
	}
}
