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
		String str = br.readLine();
		
		int M = Integer.parseInt(br.readLine());
		LinkedList<Character> list = new LinkedList<>();
		
		for (int m=0; m<str.length(); m++) {
			list.add(str.charAt(m));
		}
		
		// ListIterator는 Iterator를 상속한 인터페이스. Iterator와 달리 양방향 탐색이 가능하다.
		ListIterator<Character> iter = list.listIterator();
		// 처음 커서를 맨 뒤로 이동시켜준다. (문제 조건)
		while(iter.hasNext()) {
			iter.next();
		}
		
		//int idx = list.size(); // 커서 맨 뒤에 위치
		
		for (int i=0; i<M; i++) {
			String com = br.readLine();
			
			switch(com.charAt(0)) {
			case 'L':
				if (iter.hasPrevious()) {
					iter.previous();
				}
				break;
			case 'D':
				if (iter.hasNext()) {
					iter.next();
				}
				break;
			case 'B':
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove(); // remove는 next()나 previous()에 의해 반환된 가장 마지막 요소를 리스트에서 제거.
					// 그래서 커서를 먼저 옮김.
				}
				break;
			case 'P':
				char c = com.charAt(2); //공백이 있으므로 인덱스 값이 2
				iter.add(c);
				break;
			default:
				break;
			}
		}
		
		for (char c: list) {
			sb.append(c);
		}
		System.out.print(sb);
		
		
	}
}
