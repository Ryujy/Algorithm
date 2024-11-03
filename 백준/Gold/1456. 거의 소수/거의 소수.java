import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_1456_거의소수
public class Main {
    private static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int sqrtB = (int)Math.sqrt(B);
        prime = new boolean[sqrtB+1];
        // A <= n <= B
        // 소수의 제곱꼴 => 거의 소수
        eratos(sqrtB);
        System.out.println(find(A, B));
    }

    static void eratos(long n) {
        for (int i=2; i< prime.length; i++){
            if(!prime[i]){
                for(int j=i*2; j< prime.length; j+=i){
                    prime[j] = true;
                }
            }
        }
    }

    static int find(long A, long B){
        int ans = 0;
        for(int i = 2; i< prime.length; i++){
            if(!prime[i]){
                long temp = i;
                while(temp <= (double) B / i){
                    if(temp >= (double) A / i) {
                        ans++;
                    }
                    temp *= i;
                }
            }
        }
        return ans;
    }
}