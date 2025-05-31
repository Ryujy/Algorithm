import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class Main {

    static class Node{
        int node;
        int distance;
        Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static ArrayList<Node>[] tree;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken()); //노드의 개수
        int m = parseInt(st.nextToken()); //거리를 알고 싶은 노드 쌍의 개수
        tree = new ArrayList[n+1];
        for (int i=1; i<n+1; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());

            tree[a].add(new Node(b, d));
            tree[b].add(new Node(a, d));
        }

        StringBuilder sb = new StringBuilder();
        for (int j=0; j<m; j++){
            boolean[] visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            dfs(a, b, visited, 0);
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int start, int end, boolean[] visited, int d){
        if (start == end){
            ans = d;
        }
        visited[start] = true;
        for (Node e:tree[start]){
            int next = e.node;
            if (visited[next]) continue;
            dfs(next, end, visited, d + e.distance);
        }
    }
}
