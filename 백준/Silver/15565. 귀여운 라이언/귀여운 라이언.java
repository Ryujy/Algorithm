import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_15565 귀여운 라이언
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 인형의 수
        int k = Integer.parseInt(st.nextToken()); // 라이언 인형 연속 개수

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lion = 0, lt = 0, rt = 0, min = Integer.MAX_VALUE;
        while(rt < n){
            if(arr[rt]==1) lion++;
            if(lion >= k) {
                min = Math.min(min, rt - lt + 1);
                if(arr[lt] == 1){
                    lion--;
                    lt++;
                }
                while(arr[lt]!=1){
                    lt++;
                }
            }
            rt++;
        }
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}