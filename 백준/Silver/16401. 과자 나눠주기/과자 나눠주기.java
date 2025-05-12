import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 16401. 과자 나눠주기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 조카의 수
        int n = Integer.parseInt(st.nextToken()); // 과자의 수
        int[] snacks = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(snacks);
        // 막대 과자의 길이를 이분탐색 -> 최대 길이
        int lt = 1;
        int rt = snacks[n-1];
        int maxL = 0;

        while(lt <= rt){
            int mid = (lt+rt)/2;
            int cnt = 0;
            for (int i=0; i<n; i++){
                cnt += snacks[i]/mid;
            }
            if(cnt < m){
                rt = mid - 1;
            } else {
                lt = mid + 1;
                maxL = mid;
            }
        }
        System.out.println(maxL);
    }
}