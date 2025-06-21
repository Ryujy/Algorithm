import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static class result{
        int zero;
        int one;
        result(int zero, int one){
            this.zero = zero;
            this.one = one;
        }
    }
    static result[] fibo = new result[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp();
        int T = parseInt(br.readLine());
        for (int tc=0; tc<T; tc++){
            int n = parseInt(br.readLine());

            // 출력: 0의 횟수 | 1의 횟수
            sb.append(fibo[n].zero).append(" ").append(fibo[n].one).append('\n');
        }
        System.out.println(sb);
    }

    static void dp(){
        fibo[0] = new result(1, 0);
        fibo[1] = new result(0, 1);

        for (int i=2; i<41; i++){
            int z = fibo[i-1].zero + fibo[i-2].zero;
            int o = fibo[i-1].one + fibo[i-2].one;
            fibo[i] = new result(z, o);
        }
    }
}
