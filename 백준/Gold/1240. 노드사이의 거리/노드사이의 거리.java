import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Integer.*;
import static java.lang.Math.*;

class Main{ // 1240. 노드사이의 거리

    static class Node{
        int node;
        int distance;
        Node(int node, int distance){
            this.node = node;
            this.distance = distance;
        }
    }
    static ArrayList<Node>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 노드의 개수
        int m = Integer.parseInt(st.nextToken()); // 노드 쌍의 개수
        visited = new boolean[n+1];
        tree = new ArrayList[n+1];
        for (int k=0; k<n+1; k++){
            tree[k] = new ArrayList<>();
        }

        for (int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            tree[a].add(new Node(b, d));
            tree[b].add(new Node(a, d));
        }

        for (int j=0; j<m; j++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            getDistance(a, b, 0);
        }
    }

    private static void getDistance(int a, int b, int d){
        if(a == b){
            System.out.println(d);
            return;
        }
        visited[a] = true;
        for (Node t:tree[a]){
            if (!visited[t.node]){
                getDistance(t.node, b, d+t.distance);
            }
        }
        visited[a] = false;
    }
}