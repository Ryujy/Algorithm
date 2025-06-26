import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Integer.parseInt;

public class Main {

    static int[] kids, dp;
    static int maxLIS = 0, n;

    public static void main(String[] args) throws IOException {
        // LIS를 구하는 알고리즘은 보통 동적 계획법을 이용한다?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine()); //아이들의 수
        kids = new int[n];
        dp = new int[n];

        for(int i=0; i<n; i++){
            kids[i] = parseInt(br.readLine());
            dp[i] = 1; // 초기값: 1 <- 최소 LIS 길이는 1
        }

        // LIS : 가장 길게 증가하는 수열
        // 필요한 이동 수: 전체 사람 수 - LIS 길이
        dp();
        System.out.println(n - maxLIS);
    }

    // DP를 이용한 LIS 풀이법 */
    static void dp(){
        for (int i=0; i<n; i++){ // kids 배열 순회
            for (int j=0; j<i; j++){ // 특정 kids의 자리에서 LIS 구하기
                if (kids[j] < kids[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]); //LIS 갱신
        }
    }

}
