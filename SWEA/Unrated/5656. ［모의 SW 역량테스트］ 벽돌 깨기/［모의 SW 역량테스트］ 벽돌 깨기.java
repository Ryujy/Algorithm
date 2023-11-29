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
 
            map = new int[H][W];
 
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
                    	minBrick++; // 최종 최소 벽돌 개수가 저장될 변수
                    }
                }
            }
 
            // N개의 벽돌을 떨어트려 최대한 많은 벽돌 제거 -> W개 중 N개 => 중복 순열
            dfs(0, map, minBrick);
            System.out.println("#"+tc+" "+minBrick);
        }
    }
 
    static void dfs(int cnt, int[][] prevMap, int block) { // 공 떨어뜨린 횟수, 맵, 남은 벽돌 수
        minBrick = (block > minBrick) ? minBrick : block;
        
        if (minBrick == 0) return; // 벽돌이 다 깨짐
         
        if (cnt == N) {
            return;
        }
 
        int[][] copy = new int[H][W];
        
        // 중복 순열
        for (int i = 0; i < W; i++) { //열
             
             
            for (int j = 0; j < H; j++) { // dfs로 가져온 맵 copy맵으로 옮기기
                for (int k = 0; k < W; k++) {
                    copy[j][k] = prevMap[j][k]; // cnt 번까지 벽돌 깨고 내린 상황
                }
            }
 
            for (int j = 0; j < H; j++) { // 행
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
            for (int h = 0; h < H; h++) {
                if (copy[h][w] == 0) {
                    continue;
                }
                s.add(copy[h][w]);
                copy[h][w] = 0;
                min++;
            }
            for (int h = H - 1; h > -1; h--) {
                if (s.empty())
                    break;
                copy[h][w] = s.pop();
            }
        }
        return min;
    }
 
}