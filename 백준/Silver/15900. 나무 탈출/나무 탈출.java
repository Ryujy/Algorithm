import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] parent, child;
    static int cnt; // 게임 플레이 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        tree = new ArrayList[n+1];
        parent = new int[n+1];
        child = new int[n+1];
        for (int i=1; i<n+1; i++){
            tree[i] = new ArrayList<>();
        }
        for (int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dfs(1, 0); // 루트노드
        System.out.println((cnt % 2 == 0)? "No" : "Yes");
    }

    static void dfs(int cur, int depth){
        if (tree[cur].size() == 1 && parent[cur] == tree[cur].get(0)){ // 부모노드만 있다 = 리프노트다
            cnt += depth;
            return;
        }
        for(int child : tree[cur]){
            if(parent[cur] == child) continue;
            parent[child] = cur;
            dfs(child, depth+1);
        }
    }
}
