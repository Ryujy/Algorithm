import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_2003 수들의 합 2
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        int cnt = 0, sum = 0;
        while(end < n){
            sum += arr[end];

            while(sum > m){
                sum -= arr[start++];
            }
            if(sum == m) {
                cnt++;
            }
            end++;
        }

        System.out.println(cnt);
    }

}