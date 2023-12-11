import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 회의의 수
		
		int time[][] = new int[N][2];
		
		StringTokenizer st;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			time[n][0] = Integer.parseInt(st.nextToken()); // 회의 시작 시간 
			time[n][1] = Integer.parseInt(st.nextToken()); // 회의 끝나는 시간
		}
		
		Arrays.sort(time, (o1, o2) -> { // 끝나는 시간 빠른순으로 정렬
			if (o1[1] == o2[1]) {// 끝나는 시간이 같으면 시작 시간 빠른순 정렬
				return Integer.compare(o1[0], o2[0]);
			}
			return Integer.compare(o1[1], o2[1]);
		});
		
		int cnt = 0; // 회의 개수
		int curTime = 0; // 첫 번재 회의 시간
		for (int i=0; i < N; i++) {
			if (time[i][0] >= curTime) {// 현재 회의 끝나는 시간보다 다음 회의 시작 시간이 같거나 커야함
				curTime = time[i][1]; // 현재 회의 끝나는 시간 갱신
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
