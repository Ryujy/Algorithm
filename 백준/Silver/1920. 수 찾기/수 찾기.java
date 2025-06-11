import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main {
    static long[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = parseInt(br.readLine());
        nums = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            nums[i] = parseLong(st.nextToken());
        } // n개의 정수
        Arrays.sort(nums);

        StringBuilder sb = new StringBuilder();
        int m = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){ // 주어지는 수가 nums에 존재하는지 확인하기
            long num = parseLong(st.nextToken());
            sb.append(check(num)).append('\n');
        }
        System.out.println(sb);
    }

    static int check(long num){
        int lt = 0;
        int rt = nums.length - 1;
        while(lt <= rt){
            int mid = (lt+rt)/2;
            if(nums[mid] == num) return 1;
            else if(nums[mid] < num) lt = mid + 1;
            else rt = mid -1;
        }
        return 0;
    }
}
