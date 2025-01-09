import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// BOJ_11728 배열 합치기
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] a = new int[n];
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++){
            b[i] = Integer.parseInt(st.nextToken());
        }

        twoPointers(n, m, a, b);
    }

    private static void twoPointers(int n, int m, int[] a, int[] b){
        int p1 = 0, p2 = 0;

        StringBuilder sb = new StringBuilder();
        while(p1 < n && p2 < m){
            if(a[p1] <= b[p2]){
                sb.append(a[p1++]);
            } else {
                sb.append(b[p2++]);
            }
            sb.append(" ");
        }

        while(p1 < n){
            sb.append(a[p1++]).append(" ");
        }
        while(p2 < m){
            sb.append(b[p2++]).append(" ");
        }

        System.out.println(sb);
    }

}