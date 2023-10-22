import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		Stack<Integer> s = new Stack<>();
		for (int tc = 0; tc < T; tc++) {
			int ans = 0;
			
			String[] str = br.readLine().split(" ");
			switch(str[0]) {
			case "top":
				if (s.isEmpty()) {
					ans = -1;
				}else {
					ans = s.peek();
				}
				System.out.println(ans);
				break;
			case "empty":
				if (s.isEmpty()) ans = 1;
				else ans = 0;
				System.out.println(ans);
				break;
			case "size":
				ans = s.size();
				System.out.println(ans);
				break;
			case "pop":
				if (s.isEmpty()) {
					ans = -1;
				}else {
					ans = s.pop();
				}
				System.out.println(ans);
				break;
			case "push":
				s.push(Integer.parseInt(str[1]));
				break;
			}
		}
	}

}
