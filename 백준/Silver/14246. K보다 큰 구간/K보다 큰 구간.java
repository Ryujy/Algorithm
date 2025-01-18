import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_20922 K보다 큰 구간
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int lt = 0, rt = 0;
        long sum = 0, cnt = 0;
        while(rt < n){
            sum += arr[rt];
            while(sum > k){
                cnt += n-rt;
                sum -= arr[lt];
                lt++;
            }
            rt++;
        }
        System.out.println(cnt);
    }
}