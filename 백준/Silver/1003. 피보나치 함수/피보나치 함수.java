import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int[][] fibo = new int[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp();
        int T = parseInt(br.readLine());
        for (int tc=0; tc<T; tc++){
            int n = parseInt(br.readLine());

            // 출력: 0의 횟수 | 1의 횟수
            sb.append(fibo[n][0]).append(" ").append(fibo[n][1]).append('\n');
        }
        System.out.println(sb);
    }

    static void dp(){
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for (int i=2; i<41; i++){
            int z = fibo[i-1][0] + fibo[i-2][0];
            int o = fibo[i-1][1] + fibo[i-2][1];
            fibo[i][0] = z;
            fibo[i][1] = o;
        }
    }
}
