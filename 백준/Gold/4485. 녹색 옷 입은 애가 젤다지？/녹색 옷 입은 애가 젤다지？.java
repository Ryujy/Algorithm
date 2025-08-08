import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class Main {
    static class Link implements Comparable<Link>{
        int r;
        int c;
        int cost;
        public Link(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Link o) {
            return compare(this.cost, o.cost);
        }
    }
    static int n;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] cave, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (true){
            n = parseInt(br.readLine()); // 동굴의 크기
            if(n == 0) break;
            cnt++;
            cave = new int[n][n];
            for (int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++){
                    cave[i][j] = parseInt(st.nextToken());
                }
            } // end cave

            dijkstra();
            sb.append("Problem ").append(cnt).append(": ");
            sb.append(visited[n-1][n-1]).append("\n");
        } // tc end
        System.out.println(sb);

    }
    private static void dijkstra(){
        int INF = MAX_VALUE;
        visited = new int[n][n];
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                visited[i][j] = INF;
            }
        }
        PriorityQueue<Link> pq = new PriorityQueue<>();
        pq.offer(new Link(0, 0, cave[0][0])); // 초기 시작 (0,0)
        visited[0][0] = cave[0][0];

        while (!pq.isEmpty()) {
            Link cur = pq.poll();

            // 탈출 조건
            if (cur.cost > visited[cur.r][cur.c]) continue;
            if (cur.c == n-1 && cur.r == n-1) break;

            for (int d=0; d<4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr > -1 && nr < n && nc > -1 && nc < n){
                    int ncost = cave[nr][nc] + visited[cur.r][cur.c];
                    if (ncost < visited[nr][nc]){
                        visited[nr][nc] = ncost;
                        pq.offer(new Link(nr, nc, ncost));
                    }
                }
            }
        }
    }
}
