import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		ArrayDeque<String> q = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=0; i<N; i++) {
			String[] str = br.readLine().split(" ");
			String num = "";
			
			switch(str[0]) {
			case "push_front" :
				num = str[1];
				q.addFirst(num);
				break;
			case "push_back" :
				num = str[1];
				q.addLast(num);
				break;
			case "pop_front" :
				if (q.isEmpty()) {
					sb.append("-1");
				} else {
					sb.append(q.pollFirst());
				}
				sb.append("\n");
				break;
			case "pop_back" :
				if (q.isEmpty()) {
					sb.append("-1");
				} else {
					sb.append(q.pollLast());
				}
				sb.append("\n");
				break;
			case "size" :
				sb.append(q.size());
				sb.append("\n");
				break;
			case "empty" :
				if (q.isEmpty()) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				sb.append("\n");
				break;
			case "front" :
				if (q.isEmpty()) {
					sb.append("-1");
				} else {
					sb.append(q.peekFirst());
				}
				sb.append("\n");
				break;
			case "back" :
				if (q.isEmpty()) {
					sb.append("-1");
				} else {
					sb.append(q.peekLast());
				}
				sb.append("\n");
				break;
			}
		}
		System.out.println(sb);
		
		
	}
}
