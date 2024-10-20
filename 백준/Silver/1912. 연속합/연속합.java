import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// [BOJ] 1912 : 연속합
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] num = new int[T];
        int[] dp = new int[T];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int n=0; n<T; n++){
            num[n] = Integer.parseInt(st.nextToken());
        }

        int max = num[0];
        dp[0] = num[0];

        for (int i=1; i<T; i++){
            dp[i] = Math.max(num[i], num[i] + dp[i-1]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);



    }

}