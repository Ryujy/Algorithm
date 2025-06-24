import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {

    static int n, m;
    static int[][] map, dp;
    static int[] dr = {1, 0, 1};
    static int[] dc = {0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        map = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for (int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<m+1; j++){
                map[i][j] = parseInt(st.nextToken());
            }
        } // map end

        dp();
        System.out.println(dp[n][m]);
    }

    private static void dp(){
        dp[1][1] = map[1][1];

        for (int r=1; r<n+1; r++){
            for (int c=1; c<m+1; c++){
                for (int d=0; d<3; d++){
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr > 0 && nc > 0 && nr < n+1 && nc < m+1){
                        dp[nr][nc] = Math.max(dp[nr][nc], dp[r][c] + map[nr][nc]);
                    }
                }
            }
        }
    }
}
