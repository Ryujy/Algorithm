import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_2531 회전 초밥
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 접시의 수
        int d = Integer.parseInt(st.nextToken()); // 초밥의 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] kind = new int[d+1];
        kind[c] = 1;
        int[] chobob = new int[n+k];
        for (int i = 0; i<n; i++){
            chobob[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i<k; i++){
            chobob[n+i] = chobob[i];
        }

        int cnt = 1, max = 0;
        int lt = 0, rt = 0;
        while(rt<n+k){
            if(kind[chobob[rt]] == 0) {
                cnt++;
            }
            kind[chobob[rt]]++;
            if(rt-lt+1 == k){
                max = Math.max(cnt, max);

                kind[chobob[lt]]--;
                if (kind[chobob[lt]] == 0) cnt--;
                lt++;
            }
            rt++;
        }
        System.out.println(max);

    }
}