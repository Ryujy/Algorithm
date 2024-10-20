import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// [BOJ] 1003 : 피보나치 함수
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i=2; i<41; i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for (int tc=0; tc<T; tc++){
            int fibo = Integer.parseInt(br.readLine());
            System.out.println(dp[fibo][0] +" "+dp[fibo][1]);
        }

    }

}