import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_2960_에라토스테네스의 체
public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        prime = new boolean[n+1];

        System.out.println(Eratos(n, k));

    }

    private static int Eratos(int n, int k){
        for(int i=2; i<=n; i++){
            prime[i] = true;
        }

        int cnt = 0;
        int ans = 0;

        for(int i=2; i<=n; i++){
            if(prime[i]){
                cnt++;
                if(cnt == k) {
                    ans = i;
                    break;
                }

                for(int j=i*i; j<=n; j+=i){
                    if(!prime[j]) continue;
                    cnt++;
                    if(cnt==k) {
                        ans = j;
                        break;
                    }
                    prime[j] = false;
                }
            }
        }
        return ans;
    }

}
