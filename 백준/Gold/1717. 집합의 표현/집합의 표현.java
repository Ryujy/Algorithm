import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] parents;

	private static void makeSet() {
		parents = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			parents[i] = i; // 원소가 {1}, {2}, ... {n}
		}
	}

	private static int find(int a) {
		// 부모 찾기
		if (a == parents[a])
			return a; // 대표자가 자기 자신
		return parents[a] = find(parents[a]); // 부모의 부모를 내 부모로 => 대표자를 부모로 저장
	}

	private static void union(int a, int b) { // 합집합
		a = find(a); // 대표자 찾기
		b = find(b);

		if (a == b)
			return; // 이미 같은 집합
		if (a > b) {
			parents[a] = b;
		} else {
			parents[b] = a;
		}
		find(b); // 부모 배열 갱신
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // n개의 집합
		m = Integer.parseInt(st.nextToken());

		makeSet();
		for (int i = 0; i < m; i++) { // 연산의 개수
			st = new StringTokenizer(br.readLine());
			// 합집합 0 a b , 같은 대표자인지 확인 1 a b
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (oper == 0)
				union(a, b);
			else {
				a = find(a);
				b = find(b);
				if (a == b)
					sb.append("YES");
				else
					sb.append("NO");
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
