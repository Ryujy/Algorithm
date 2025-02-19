import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N,M,H, cnt;
    static int[] dr = {0, 0, -1, 1, 0, 0}; //동서남북상하
    static int[] dc = {-1, 1, 0, 0, 0, 0}; //동서남북상하
    static int[] dl = {0, 0, 0, 0, -1, 1}; //동서남북상하
    static int[][][] tomato;
    static ArrayDeque<Node> que = new ArrayDeque<>();
    private static class Node {
        int r;
        int c;
        int l;

        Node(int r, int c, int l){
            this.r = r;
            this.c = c;
            this.l = l;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열 c
        N = Integer.parseInt(st.nextToken()); // 행 r
        H = Integer.parseInt(st.nextToken()); // 층 l

        tomato = new int[N][M][H];

        cnt = 0;
        for (int h = 0; h < H; h++){
            for (int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++){
                    int i = Integer.parseInt(st.nextToken());
                    tomato[n][m][h] = i;
                    if(i == 1) { //익은 토마토 체크
                        que.offer(new Node(n, m, h));
                    }
                    if(i != -1) cnt++;
                }
            }
        } // 입력 끝

        int res = bfs();
        System.out.println(res);
    }

    public static int bfs(){
        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();

            for (int i=0; i<size; i++){
                Node cur = que.poll();
                cnt--;

                for (int d=0; d<6; d++){
                    int nr = cur.r + dr[d];
                    int nc = cur.c + dc[d];
                    int nl = cur.l + dl[d];

                    if(nr < 0 || nc < 0 || nl < 0 || nr >= N || nc >= M || nl >= H
                            || tomato[nr][nc][nl] != 0) continue;
                    que.offer(new Node(nr, nc, nl));
                    tomato[nr][nc][nl] = 1; // 방문체크
                }
            }
            time++;
        }
        return (cnt==0?time-1:-1);
    }
}
