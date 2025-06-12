import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static class Node{
        int node;
        int distance;
        Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static int maxDistance = 0, farthestNode = 0;
    static ArrayList<Node>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine()); //정점의 개수
        tree = new ArrayList[n+1];
        for (int i=1;i<n+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = parseInt(st.nextToken());
            tree[node] = new ArrayList<>();

            while (true){
                int a = parseInt(st.nextToken());
                if (a == -1) break;
                int d = parseInt(st.nextToken());
                tree[node].add(new Node(a, d));
            }
        }
        // 1. 임의의 노드에서 가장 먼 노드 찾는 dfs
        boolean[] visited = new boolean[n+1];
        dfs(1, 0, visited);

        // 2. 가장 먼 노드에서 지름을 찾는 dfs
        visited = new boolean[n+1];
        maxDistance = 0; // 지름 시작이므로 초기화
        dfs(farthestNode, maxDistance, visited);
        System.out.println(maxDistance);
    }

    static void dfs(int cur, int dis, boolean[] visited){
        visited[cur] = true;
        if(dis > maxDistance){
            maxDistance = dis;
            farthestNode = cur;
        }
        for (Node next:tree[cur]){
            if(visited[next.node]) continue;
            dfs(next.node, dis + next.distance, visited);
        }
//        visited[cur] = false;

    }
}
