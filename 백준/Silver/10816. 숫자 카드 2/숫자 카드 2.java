import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = parseInt(br.readLine());
        HashMap<Integer, Integer> num = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            int k = parseInt(st.nextToken());
            int v = num.getOrDefault(k,0);
            num.put(k, v+1);
        }

        StringBuilder sb = new StringBuilder();
        int m = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            int t = parseInt(st.nextToken());
            sb.append(num.getOrDefault(t,0)).append(' ');
        }

        System.out.println(sb);
    }
}
