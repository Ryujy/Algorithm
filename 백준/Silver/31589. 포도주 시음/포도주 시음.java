import java.io.*;
import java.util.*;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] t = new int[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) t[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(t);

        long ans = t[n-1];
        int lo = 0, hi = n-2, cnt = k-1;
        while(cnt > 1) {
            ans += t[hi--] - t[lo++];
            cnt -= 2;
        }

        System.out.println(ans);
    }
}