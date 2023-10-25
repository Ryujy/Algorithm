import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static boolean[] v;
	static ArrayList<Integer>[] adj;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
       adj = new ArrayList[N+1];
       
        for (int i=0; i<N+1; i++) {
        	adj[i] = new ArrayList<>();
        }
        v = new boolean[N+1];
        
        for (int i=0; i<M; i++) {
        	st = new StringTokenizer(br.readLine());
        	int u = Integer.parseInt(st.nextToken());
        	int v = Integer.parseInt(st.nextToken());
        	
        	adj[u].add(v);
        	adj[v].add(u);
        }
        int cnt = 0;
        for (int i=1; i < N+1; i++) {
        	if (!v[i]) {
        		dfs(i);
        		cnt++;
        	}
        }
        System.out.println(cnt);
    }

	private static void dfs(int i) {
		int size = adj[i].size();
		
		if (v[i]) {
			return;
		}
		
		v[i] = true;
		
		for (int a=0; a<size; a++ ) {
			int node = adj[i].get(a);
			if (!v[node]) {
				dfs(node);
			}
		}
	}
}
