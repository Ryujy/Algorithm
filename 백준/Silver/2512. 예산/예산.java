import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 2512. 예산
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 지방의 수
        int[] cities = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()); // 각 지방의 예산 요청
        for (int i=0; i<n; i++){
            cities[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine()); // 총 예산

        Arrays.sort(cities);
        int lt = 0;
        int rt = cities[n-1];
        int res = 0;

        while (lt <= rt){
            int mid = (lt + rt)/2;
            int total = 0;

            for (int c: cities){
                total += Math.min(c, mid);
            }
            if (total > m){
                rt = mid -1;
            } else {
                lt = mid +1;
                res = mid;
            }
        }
        System.out.println(res);
    }
}