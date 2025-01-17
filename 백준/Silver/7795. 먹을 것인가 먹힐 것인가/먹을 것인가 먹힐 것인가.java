import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_7795 먹을 것인가 먹힐 것인가
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // A의 수
            int m = Integer.parseInt(st.nextToken()); // B의 수

            int[] a = new int[n];
            int[] b = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<m; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(a);
            Arrays.sort(b);

            int at = 0, bt = 0, cnt = 0;
            while(at < n && bt < m){
                if(a[at] > b[bt]) {
                    cnt+=(n-at);
                    bt++;
                } else {
                    at++;
                }
            }

            System.out.println(cnt);
        }


    }
}