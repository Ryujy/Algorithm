package b_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_에라토스테네스체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] prime = new boolean[n+1];
        // false = 소수o , true = 소수x
        prime[1] = true;
        int cnt = 0;

        for (int i=2; i<=n; i++){
            if(!prime[i]){
                cnt++;
                // 조건 부분 자꾸 틀림!
                for (int j=i; j<=n; j+=i){
                    // j=i*i는 i*i가 int 범위를 초과하지 않을 때 가능
                    prime[j] = true;
                }
            }
        }

        System.out.println(cnt);
    }
}
