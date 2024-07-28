import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m; // 전체 사람의 수
	static int a, b; // 촌수 계산할 두 사람
	static int[][] graph;
	static boolean[] visited;
	static int ans;
	static Queue<int[]> q = new ArrayDeque<int[]>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine()); // 전체 사람의 수 입력받기
		graph = new int[n][n];

		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken()) -1; // 촌수 계산할 1인
		b = Integer.parseInt(st.nextToken()) -1; // 촌수 계산할 2인

		m = Integer.parseInt(br.readLine()); // 부모 자식들 간의 관계의 개수
		visited = new boolean[n]; // 해당 인덱스 사람 방문 체크 여부

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) -1; // y의 부모
			int y = Integer.parseInt(st.nextToken()) -1; // x의 자식
			graph[x][y] = graph[y][x] = 1; 
		}
		
		bfs(a);

	}
	
	static void bfs(int a) {
		q.offer(new int[] {a,0});  //큐에 시작점 넣고
		visited[a] = true; // 방문체크
		
		while(!q.isEmpty()) {
			int[] num = q.poll(); // 뽑았고
			int vertex = num[0];
			int depth = num[1]; // 촌수
			int size = graph[vertex].length;
			
			if (vertex == b) {
				System.out.println(depth);  // depth넣기!!
				return;
			}
			
			for (int i=0; i < size; i++) { // i가 num노드와 연결된 노드 탐색
				if(graph[vertex][i] == 0) continue; // 연결되지 않은 노드
				if (visited[i]) continue; // 연결되었으나 이미 방문한 노드
				q.offer(new int[] {i,depth+1});
				visited[i] = true;
			}
		}
		System.out.println(-1);
	}


}
