import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_3273 두 수의 합
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        // 1 2 3 5 7 9 10 11 12
        int x = Integer.parseInt(br.readLine());

        int lt = 0, rt = n-1, sum = 0, cnt = 0;

        while(lt < rt){
            sum = arr[lt] + arr[rt];
            if(sum == x) {
                cnt++;
                lt++;
                rt--;
            } else if(sum > x){
                rt--;
            } else {
                lt++;
            }
        }

        System.out.println(cnt);
    }

}