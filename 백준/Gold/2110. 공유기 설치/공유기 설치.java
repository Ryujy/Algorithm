import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 2110. 공유기 설치
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 집의 개수 N
        int c = Integer.parseInt(st.nextToken()); // 공유기 개수 C
        int[] houses = new int[n]; // 집의 좌표
        for (int i=0; i<n; i++){
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        // 구해야 할 것: 공유기 간 최소 거리의 최대화 (mid)
        int maxD = 1;
        // mid 거리 기준 필요한 공유기 수 -> c 개 이상이면 줄이기
        // 공유기 간 최소 거리 범위 (1 ~ houses[n-1] - houses[0])
        int lt = 1;
        int rt = houses[n-1] - houses[0];

        while(lt<=rt){
            int mid = (rt + lt)/2;
            int route = 1; // 첫 집에는 무조건 설치
            int last = houses[0]; // 마지막으로 설치한 집
            for (int i=1; i<n; i++){
                if ((houses[i] - last) >= mid){
                    route++;
                    last = houses[i];
                }
            }

            if (route >= c){
                lt = mid + 1;
                maxD = mid;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(maxD);
    }
}