import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String str = br.readLine();

			Stack<String> s = new Stack<>();
			
			String ans = "YES";

			for (int ch = 0; ch < str.length(); ch++) {
				char in = str.charAt(ch);

				if (!s.isEmpty() && in == ')') {
					if (s.peek().equals("(")) {
						s.pop();
					}
				} else if (in == '(') {
					s.push("(");
				} else {
					ans = "NO";
				}
			}
			
			if (!s.isEmpty()) {
				ans = "NO";
			}
			System.out.println(ans);
		}
	}

}
