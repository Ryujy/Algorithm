import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
 
 
// SWEA_핀볼게임
public class Solution {
     
    static int N, dir, score, maxScore;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0 , 0, -1, 1};
    static ArrayList<Data> start;
    static class Data{
        int r;
        int c;
        public Data(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
         
        for (int tc=1; tc<T+1; tc++) { //tc
            N = Integer.parseInt(br.readLine().trim());
            
            map = new int[N][N];
            start = new ArrayList<>();
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 0) { // 게임을 시작할 수 있는 위치 저장
                        start.add(new Data(i,j)); // 방향은 어차피 4방향 탐색할거니까.. 상관x?
                    }
                }
            } //map end
            maxScore = -1;
            bfs(); // 시작 위치 선정 경우의 수 + 게임 진행 ㄱㄱ
            System.out.println("#"+tc+" "+maxScore);
        } //tc end
         
    }
     


    // 게임판 위에서 출발 위치와 진행 방향을 임의로 선정가능 할 때,
    // 게임에서 얻을 수 있는 점수의 최댓값을 구하여라! (단, 블록, 웜홀 또는 블랙홀이 있는 위치에서는 출발할 수 없다.)
    private static void bfs() {
        
        for (int i=0; i<start.size(); i++) { //가능한 시작 위치 뽑아서
            Data st = start.get(i);
            
            
            for (int d=0; d<4; d++) { // 4방향 탐색
//                int nr = st.r + dr[d];
//                int nc = st.c + dc[d];
                dir = d;
                
//                if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) { // 범위 유효성 판단
//                    continue;
//                }
                
                score = 0; // 시작위치, 방향에 따른 경우의 수 -> 점수 초기화
                play(st.r, st.c);
                maxScore = (maxScore > score)?maxScore : score;
            }
        }
        
    }
    
    private static void play(int r, int c) {
        int nr = r;
        int nc = c;
        while (true) {
            nr += dr[dir];
            nc += dc[dir];
            
            
            // 게임 진행 ing
            // 점수는 벽이나 블록에 부딪힌 횟수가 된다. 
            if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1 || map[nr][nc] == 5) { //벽에 충돌 -> 점수, 방향 전환 // 블록 5번도 동일.
            	score = score * 2 +1;
                return;
            }
            
            if (map[nr][nc] > 0 && map[nr][nc] < 5) {// 블록에 충돌 -> 점수, 방향 전환
                score++;
                // 블록의 수평면이나 수직면을 만날 경우 방향을 바꿔 반대 방향으로 돌아오고, 경사면을 만날 경우에는 직각으로 진행 방향이 꺾이게 된다.
                int m = map[nr][nc];
                switch(m) {
                case 1: 
                    if (dir == 0) dir += 1; // 상 -> 하
                    else if (dir == 3) dir -= 1; //우 -> 좌
                    else if (dir == 1) dir += 2; //하 -> 우
                    else dir -= 2; // 좌 -> 상
                    break;
                case 2:
                    if (dir == 1) dir -= 1; //하-> 상
                    else if (dir == 3) dir -= 1; //우 -> 좌
                    else if (dir == 0) dir += 3; //상->우
                    else dir -= 1; //좌->하
                    break;
                case 3:
                    if (dir == 1) dir -= 1; //하-> 상
                    else if (dir == 2) dir += 1; // 좌 -> 우
                    else if (dir == 3) dir -= 2; // 우 -> 하
                    else dir += 2; // 상 -> 좌
                    break;
                case 4:
                    dir = (dir + 1) % 4; // 상->하->좌->우->상
                    break;
                }
                continue;
            }
            
         // 게임 end
            if ((nr == r && nc == c) || map[nr][nc] == -1) return; // 블랙홀 or 출발 지점으로 돌아옴.
            
            // 핀볼이 웜홀에 빠지면 동일한 숫자를 가진 다른 반대편 웜홀로 빠져 나오게 되며 진행방향은 그대로 유지된다.
            // (웜홀을 통과하는 것은 점수에 포함되지 않는다.)
            if (map[nr][nc] > 5 && map[nr][nc] < 11) {
                Data pair = find (nr, nc, map[nr][nc]);
                nr = pair.r;
                nc = pair.c;
                continue;
            }
            
        }
    }
    
    private static Data find(int r, int c, int num) {
        int wr = r;
        int wc = c;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if ((i != r || j != c) && map[i][j] == num) {
                    wr = i;
                    wc = j;
                }
            }
        }
        Data pair = new Data(wr, wc);
        return pair;
    }
}
