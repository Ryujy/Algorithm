package b_array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_보이는학생 {
    public static void solution(int n, int[] students){
        int cnt = 1;
        int max = students[0];
        for (int i=1; i<n; i++){
            if(max < students[i]){
                cnt++;
                max = students[i];
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] student = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            student[i] = Integer.parseInt(st.nextToken());
        }
        B_보이는학생 T = new B_보이는학생();
        T.solution(n, student);
    }
}
