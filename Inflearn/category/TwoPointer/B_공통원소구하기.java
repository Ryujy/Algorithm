package c_twoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_공통원소구하기 {
    public static void main(String[] args) throws IOException {
        /* A, B 두 개의 집합이 주어질 때, 두 집합의 공통 원소를 추출하여 오름차순으로 출력하라.
        * 1. 주어진 집합 오름차순 정렬
        * 2. 두 포인터로 비교하여 같은 수 정답에 추가
        * */

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

        twoPointer(n, m, a, b);
    }

    private static void twoPointer(int n, int m, int[] a, int[] b){
        // * 1. 주어진 집합 오름차순 정렬
        Arrays.sort(a);
        Arrays.sort(b);

        StringBuilder sb = new StringBuilder();
        // * 2. 두 포인터로 비교하여 같은 수 정답에 추가
        int p1 = 0, p2 = 0;
        while (p1 < n && p2 < m){
            if(a[p1] == b[p2]){
                sb.append(a[p1++]).append(" ");
                p2++;
            } else if (a[p1] < b[p2]){
                p1++;
            } else {
                p2++;
            }
        }

        System.out.println(sb);
    }
}
