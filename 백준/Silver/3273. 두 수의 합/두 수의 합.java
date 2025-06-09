import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = parseInt(st.nextToken());
        }
        int x = parseInt(br.readLine());
        Arrays.sort(arr);

        int lt = 0;
        int rt = n-1;
        int cnt = 0;
        // 1 2 3 5 7 9 10 11 12
        while (lt < rt){
            int sum = arr[lt] + arr[rt];
            if(sum <= x){
                if (sum == x){
                    cnt++;
                }
                lt++;
            } else {
                rt--;
            }
        }
        System.out.println(cnt);
    }
}
