import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

// 백준 - 수 묶기
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> pos = new ArrayList<>();
		ArrayList<Integer> neg = new ArrayList<>();
		for (int i=0; i<N; i++) {
			int val = Integer.parseInt(br.readLine());
			if (val > 0) pos.add(val); //양수
			else neg.add(val); //음수
		}
		Collections.sort(pos, Collections.reverseOrder());
		Collections.sort(neg);
		
		int res = 0;
		//positive
		for (int i=0; i<pos.size(); i++) {
			if (i+1 < pos.size() && pos.get(i) != 1 && pos.get(i+1) != 1) {
					res += (pos.get(i++) * pos.get(i));
			} else {
				res += pos.get(i);
			}
		}
		// negative
		for (int i=0; i<neg.size(); i++) {
			if (i+1 < neg.size()) {
				res += (neg.get(i++) * neg.get(i));
			} else {
				res += neg.get(i);
			}
		}
		
		System.out.println(res);
	}
}