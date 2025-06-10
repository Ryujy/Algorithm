import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main { //https://www.acmicpc.net/problem/22254
    static int n, x;
    static int[] time;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken()); // 선물 주문의 개수
        x = parseInt(st.nextToken()); // 제작 완료까지 남은 시간
        st = new StringTokenizer(br.readLine());
        time = new int[n]; // 선물에 필요한 공정 시간
        for (int i=0; i<n; i++){
            time[i] = parseInt(st.nextToken());
        }
        // x시간 이내에 모든 선물을 제작하기 위해 필요한 최소 공정 라인 개수 출력
        // 특정 라인 개수이면 x시간 안에 제작 가능한가?
        int lt = 1, rt = n; // 공정 라인의 최소, 최대
        int k = MAX_VALUE;
        while(lt<=rt){
            int mid = (lt+rt)/2;

            if (run(mid)){ // mid <= x
                k = mid;
                rt = mid -1;
            } else {
                lt = mid +1;
            }
        }
        System.out.println(k);
    }

    static boolean run(int m){
        pq = new PriorityQueue<>();
        for (int i=0; i<m; i++){ //공정라인 초기값 세팅
            pq.add(time[i]);
        }
        for (int i=m; i<n; i++){
            int tmp = pq.poll();
            tmp += time[i];
            if (tmp > x) return false;
            pq.add(tmp);
        }
        return true;
    }
}
