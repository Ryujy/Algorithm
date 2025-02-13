import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main { // BOJ_1697_숨바꼭질

    static int n, k;
    static boolean[] visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 수빈
        k = Integer.parseInt(st.nextToken()); // 동생

        bfs();
    }

    private static void bfs(){
        ArrayDeque<int[]> que = new ArrayDeque<>();
        que.offer(new int[] {n, 0});

        while (!que.isEmpty()){
            int[] tmp = que.poll();
            int cl = tmp[0]; //현재 위치
            int ct = tmp[1]; //현재 시간
            visit[cl] = true;

            if (cl == k){
                System.out.println(ct);
                break;
            }

            if (valid(cl-1)) {
                que.offer(new int[] {cl-1, ct+1});
            }
            if (valid(cl+1)) {
                que.offer(new int[] {cl+1, ct+1});
            }
            if (valid(cl*2)) {
                que.offer(new int[] {cl*2, ct+1});
            }
        }
    }

    private static boolean valid(int n){
        if(n < 0 || n > 100000 || visit[n]){
            return false;
        }
        return true;
    }
}