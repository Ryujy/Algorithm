import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_1940 주몽
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] el = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            el[i] = Integer.parseInt(st.nextToken());
        }
        // 1 2 3 4 5 7
        Arrays.sort(el);
        int lt = 0, rt = n-1;
        int cnt = 0;
        while(lt < rt){
            int sum = el[lt] + el[rt];
            if(sum <= m){
                lt++;
                if (sum == m) cnt++;
            } else {
                rt--;
            }
        }

        System.out.println(cnt);
    }
}