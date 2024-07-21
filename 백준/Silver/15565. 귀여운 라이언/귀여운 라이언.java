import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 라이언, 어피치 인형 개수
        int K = Integer.parseInt(st.nextToken()); // 라이언 인형 K개

        int[] arr = new int[N]; // 인형 배열

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) { // 1 - 라이언, 2 - 어피치
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int start=0, end=0; start<N; start++) {
            while (end < N && cnt < K) { // K개 이상 조건이 미충족
                if (arr[end] == 1) cnt++;
                end++;
            }
            int len = end - start;
            if (cnt == K) min = min > len ? len : min;
            if (arr[start] == 1) cnt--;
        }
        if (min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }
}