import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());

        HashMap<String, String> dic = new HashMap<>();

        for (int i=1; i<n+1; i++){
            String name = br.readLine();
            dic.put(String.valueOf(i), name);
            dic.put(name, String.valueOf(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int j=0; j<m; j++){
            String q = br.readLine();
            sb.append(dic.get(q)).append('\n');
        }
        System.out.println(sb);
    }
}
