import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] cats = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cats[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cats);

        int start = 0;
        int end = n - 1;
        int count = 0;

        while (start < end) {
            int result = cats[start] + cats[end];
            if (result > k) {
                end--;
            } else if (result <= k) {
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
    }
}