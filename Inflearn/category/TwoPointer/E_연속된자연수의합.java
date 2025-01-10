package c_twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class E_연속된자연수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int p1 = 1, p2 = 2;
        int cnt = 0, sum = p1;

        while (p1 < p2){
            if(p2 > n/2+1) break; // ***
            sum += p2;
            while(sum > n){
                sum -= p1++;
            }
            if(sum == n) cnt++;
            p2++;
        }
        System.out.println(cnt);
    }
}
