package b_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_피보나치수열 {
    public static void main(String[] args) throws IOException {
        // 피보나치 수열 : 앞의 2개의 수를 합하여 다음 숫자가 되는 수열.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] pivo = new int[n];
        pivo[0] = 1;
        pivo[1] = 1;

        for (int i=2; i<n; i++){
            pivo[i] = pivo[i-2] + pivo[i-1];
        }

        for (int p : pivo){
            System.out.print(p + " ");
        }
    }
}
