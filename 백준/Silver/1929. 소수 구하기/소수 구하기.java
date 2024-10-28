import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// BOJ_1929_소수구하기
public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        prime = new boolean[n+1];
        Eratos(n); // 소수 판별 완료

        for(int i=m; i<=n; i++){
            if(prime[i]){
                System.out.println(i);
            }
        }
    }

    public static void Eratos(int n){
        for(int i=2; i< n+1; i++){ //처음엔 모두 소수로 봄.
            prime[i] = true;
        }

        for(int j=2; j*j<n+1; j++){
            if(prime[j]){ // j가 true이면 j 이후의 j의 배수는 약수로 j를 갖고 있다는 의미 => 소수 X
                for(int k= j*j; k<=n; k += j){ // ?? : j * j <- j보다 낮은 수를 곱한 배수는 이미 false
                    prime[k] = false;
                }
            }
        }
    }

}
