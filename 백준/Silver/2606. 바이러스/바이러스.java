import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static ArrayList<Integer>[] map;
    static int cnt = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine()); // 컴퓨터의 수
        map = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i=0; i<n+1; i++){
            map[i] = new ArrayList<>();
        }

        int m = parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());

            map[a].add(b);
            map[b].add(a);
        }

        visited[1] = true;
        dfs(1);
        System.out.println(cnt);
    }

    static void dfs(int start){
        for (int node : map[start]){
            if (!visited[node]){
                cnt++;
                visited[node] = true;
                dfs(node);
            }
        }
    }
}
