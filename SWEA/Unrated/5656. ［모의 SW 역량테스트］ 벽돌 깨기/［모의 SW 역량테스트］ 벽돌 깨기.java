import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
 
public class Solution {
 
    static int N, W, H, minBrick;
    static int[][] map;
    static int[] dh = { -1, 1, 0, 0 };
    static int[] dw = { 0, 0, -1, 1 };
    static ArrayDeque<Data> q = new ArrayDeque<>();
 
    static class Data {
        int h;
        int w;
        int scope;
 
        public Data(int h, int w, int scope) {
            this.h = h;
            this.w = w;
            this.scope = scope;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc < T + 1; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
 
            map = new int[H + 1][W];
 
            for (int h = 0; h < H; h++) {
                st = new StringTokenizer(br.readLine());
                for (int w = 0; w < W; w++) {
                    map[h][w] = Integer.parseInt(st.nextToken());
                }
            }
             
            minBrick = 0;
            for (int i = 0; i < W; i++) {
                for (int j = 0; j < H; j++) {
                    if (map[j][i] != 0) {
                        map[H][i] += 1;
                    }
                }
                minBrick += map[H][i];
            }
 
            // N개의 벽돌을 떨어트려 최대한 많은 벽돌 제거 -> W개 중 N개 => 중복 순열
            dfs(0, map, minBrick);
            System.out.println("#"+tc+" "+minBrick);
        }
    }
 
    static void dfs(int cnt, int[][] prevMap, int block) {
        minBrick = (block > minBrick) ? minBrick : block;
         
        if (cnt == N) {
            return;
        }
 
        int[][] copy = new int[H+1][W];
         
        for (int i = 0; i < W; i++) {
             
             
            for (int j = 0; j < H; j++) { // dfs로 가져온 맵 copy맵으로 옮기기
                for (int k = 0; k < W; k++) {
                    copy[j][k] = prevMap[j][k];
                }
            }
 
            for (int j = 0; j < H; j++) {
                if (copy[j][i] != 0) {
                    int b = broke(j, i, copy);
                    dfs(cnt + 1, copy, b);
                    break;
                }
            }
             
        }
    }
 
    private static int broke(int h, int w, int[][] copy) {
 
        ArrayDeque<Data> q = new ArrayDeque<>();
        q.offer(new Data(h, w, copy[h][w]));
        copy[h][w] = 0;
 
        while (!q.isEmpty()) {
            Data cur = q.poll();
 
            for (int d = 0; d < 4; d++) {
                for (int s = 1; s < cur.scope; s++) {
                    int nh = cur.h + dh[d] * s;
                    int nw = cur.w + dw[d] * s;
 
                    if (nh < 0 || nh > H - 1 || nw < 0 || nw > W - 1) {
                        break;
                    }
                    if (copy[nh][nw] == 0) {
                        continue;
                    }
                    q.offer(new Data(nh, nw, copy[nh][nw]));
                    copy[nh][nw] = 0;
                }
            }
 
        }
        return down(copy);
 
    }
 
    private static int down(int[][] copy) {
        int min = 0;
        Stack<Integer> s = new Stack<>();
 
         
        for (int w = 0; w < W; w++) {
            int cnt = 0;
            for (int h = 0; h < H; h++) {
                if (copy[h][w] == 0) {
                    continue;
                }
                s.add(copy[h][w]);
                copy[h][w] = 0;
                cnt++;
            }
            copy[H][w] = cnt;
            for (int h = H - 1; h > -1; h--) {
                if (s.empty())
                    break;
                copy[h][w] = s.pop();
            }
            min += cnt;
        }
        return min;
    }
 
}