import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Main {

    static int[][] map, dp;
    static int[] min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int  n  = parseInt(br.readLine());
        map = new int[n][3];
        dp = new int[n][3];
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = parseInt(st.nextToken());
            map[i][1] = parseInt(st.nextToken());
            map[i][2] = parseInt(st.nextToken());

            // 출력: 최대 점수 , 최소 점수
        }

        dp();
        int maxValue = Math.max(max[0], Math.max(max[1], max[2]));
        int minValue = Math.min(min[0], Math.min(min[1], min[2]));
        System.out.println(maxValue+" "+minValue);
    }

    static void dp(){
        min = new int[3];
        max = new int[3];

        for (int i=0; i<3; i++){ // min, max 초기화
            min[i] = max[i] = map[0][i];
        }

        for (int i=1; i<map.length; i++) {
            // max 갱신
            int tmp = max[1];
            max[1] = Math.max(max[0], Math.max(max[1], max[2])) + map[i][1];
            max[2] = Math.max(tmp, max[2]) + map[i][2];
            max[0] = Math.max(tmp, max[0]) + map[i][0];

            // min 갱신
            tmp = min[1];
            min[1] = Math.min(min[0], Math.min(min[1], min[2])) + map[i][1];
            min[2] = Math.min(tmp, min[2]) + map[i][2];
            min[0] = Math.min(tmp, min[0]) + map[i][0];
        }
    }
}
