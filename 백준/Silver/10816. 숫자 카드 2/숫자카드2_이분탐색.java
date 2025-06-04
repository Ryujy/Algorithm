import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import static java.lang.Integer.*;

public class BOJ_10816_숫자카드2 { // 이분탐색으로 풀어보기

    static int n;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = parseInt(br.readLine());
        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            nums[i] = parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        int m = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++){
            int t = parseInt(st.nextToken());
            int res = upperBound(t) - lowerBound(t);
            sb.append(res).append(" ");
        }

        System.out.println(sb);
    }

    static int upperBound(int target) {
        int lt = 0;
        int rt = n;
        while(lt < rt){
            int mid = (lt+rt)/2;
            if (nums[mid] > target) rt = mid;
            else lt = mid + 1;
        }
        return lt;
    }

    static int lowerBound(int target) {
        int lt = 0;
        int rt = n;
        while(lt < rt){
            int mid = (lt+rt)/2;
            if (nums[mid] >= target) rt = mid;
            else lt = mid + 1;
        }
        return lt;
    }
}
