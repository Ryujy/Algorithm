package c_twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C_최대매출 {
    public static void main(String[] args) throws IOException {
        /* n일 동안의 매출 기록 중에서
        * 연속된 k일 동안의 최대 매출액 구하기
        * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int sum = 0;
        /* 틀린 부분!!!!! k가 변수인데 생각 못함 ㅋ*/
        for (int i=0; i<k; i++){
            sum += arr[i];
        }
        int max = sum;
        while (p1 < (n - k)) {
            sum += arr[p1+k];
            sum -= arr[p1++];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
