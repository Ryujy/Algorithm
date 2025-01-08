package c_twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_두배열합치기 {
    public static void main(String[] args) throws IOException {
        /* "오름차순으로 정렬이 된" 두 배열이 주어졌을 때,
         * 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하라.
         * => * 두 포인터 알고리즘은 주로 정렬된 배열에서 사용되면, 시간복잡도를 줄이는 데 유용하다.
         *
         * **** 사용 사례 ****
         * 1. 정렬된 배열에서 사용
         * 2. 부분 배열의 합 찾기 (특정 합을 가지는 연속된 부분 배열 찾기)
         * 3. 투 포인터 슬라이딩 윈도우 (문자열/배열에서 특정 조건을 만족하는 가장 긴/짧은 부분 찾기)
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        twoPointers(n, m, a, b);
    }

    private static void twoPointers(int n, int m, int[] a, int[] b){
        StringBuilder sb = new StringBuilder();
        int p1 = 0, p2 = 0;

        while(p1<n && p2<m){
            if(a[p1] <= b[p2]){
                sb.append(a[p1++]);
            } else {
                sb.append(b[p2++]);
            }
            sb.append(" ");
        }

        while (p1<n){
            sb.append(a[p1++]).append(" ");
        }
        while (p2<m){
            sb.append(b[p2++]).append(" ");
        }

        System.out.println(sb);
    }
}
