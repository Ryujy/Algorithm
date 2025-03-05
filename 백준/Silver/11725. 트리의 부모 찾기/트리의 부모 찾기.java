import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());


        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[N+1];
        for(int i = 1; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            adj[x].add(y);
            adj[y].add(x);

        }

        parent = new int[N+1];
        dfs(1);

        for(int i = 2; i <= N; i++) {
            sb.append(parent[i]).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int index) {
        visited[index] = true;

        for(int i : adj[index]) {
            if(!visited[i]) {
                parent[i] = index;
                dfs(i);
            }
            
        }

    }

}
