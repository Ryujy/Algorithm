import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    static int[][] graph, ans;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine()); // 정점의 개수
        StringTokenizer st;
        graph = new int[n][n];
        ans = new int[n][n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++){
                graph[i][j] = parseInt(st.nextToken());
            }
        } // graph input

        for (int i=0; i<n; i++){
            boolean[] visited = new boolean[n];
            dfs(i, i, visited);
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void dfs(int start, int current, boolean[] visited){
        for (int next=0; next<n; next++){
            if(graph[current][next] == 1 && !visited[next]){ // 간선 존재 && 방문X
                visited[next]= true;
                ans[start][next] = 1; // 경로가 존재
                dfs(start, next, visited);
            }
        }
    }
}
