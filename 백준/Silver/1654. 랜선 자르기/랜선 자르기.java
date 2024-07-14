import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());  //가지고 있는 랜선의 개수
        int N = Integer.parseInt(st.nextToken());  // 필요한 랜선의 개수

        int[] len = new int[K];

        for(int i=0; i<K; i++){  // 가지고 있는 랜선들의 길이
            len[i] = Integer.parseInt(br.readLine());
        }
        
        // 랜선 길이 정렬
        Arrays.sort(len);

        // 이분탐색
        long start = 1; // 최소 길이
        long end = len[K-1]; // 최대 길이 = 가장 긴 랜선
        long mid, cnt;

        while(start<=end){
            mid = (end + start)/2;
            cnt = 0;

            for(int i=0; i<K; i++){ //현재 mid로 구할 수 있는 랜선 개수
                cnt += len[i]/mid;
            }

            if (cnt < N) end = mid - 1;
            else start = mid + 1;
        }

        System.out.println(end);
    }
}