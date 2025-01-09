import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_2018 수들의 합 5
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int p1 = 1, p2 = 1;
        int sum = p1, cnt = 1;
            while(p1 < n){
                if (sum == n){
                    cnt++;
                    sum -= p1++;
                    sum += ++p2;
                } else if(sum < n) {
                    sum += ++p2;
                } else {
                    sum -= p1++;
                }
            }
        

        System.out.println(cnt);
    }

}