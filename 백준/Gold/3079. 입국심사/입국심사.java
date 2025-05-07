import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 3079. 입국심사
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 심사관 수
        long m = Integer.parseInt(st.nextToken()); // 입국 인원수
        int[] time = new int[n];
        for (int i=0; i<n; i++){
            time[i] = Integer.parseInt(br.readLine());
        }

        // 구할 것: 심사 받는 시간 최솟값 => 기준: 시간
        // 시간에 따라 심사 가능한 인원 수 => 이분탐색
        Arrays.sort(time);
        long lt = 1; // 심사 최소 시간
        long rt = time[n-1] * m; // 심사 최악 시간
        long minT = 0;
        while(lt <= rt){
            long mid = (lt+rt)/2;
            long cnt = 0;

            // 각 심시관 별 처리 가능한 인원의 합 => 총 처리 가능 인원
            // 순서가 중요하지 않으므로.
            for (int i=0; i<n; i++){
                cnt += mid/time[i];
                if(cnt >= m) break; // 🍎 틀린 요인: cnt의 오버플로우 위험
            }

            if(cnt >= m){
                rt = mid - 1;
                minT = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(minT);
    }
}
