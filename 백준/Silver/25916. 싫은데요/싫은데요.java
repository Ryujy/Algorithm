import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_25916 싫은데요
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        long sum = 0, max = 0;
        for (int rt=0; rt<n; rt++){
            sum += arr[rt];
            while(sum > m){
                sum -= arr[lt];
                lt++;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}