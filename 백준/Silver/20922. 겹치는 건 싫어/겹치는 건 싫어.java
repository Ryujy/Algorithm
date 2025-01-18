import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_20922 겹치는 건 싫어
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] nums = new int[100001];
        int lt = 0, rt = 0, max = 0;
        while(rt < n){
            while(nums[arr[rt]] >= k){
                nums[arr[lt]]--;
                lt++;
            }
            nums[arr[rt]]++;
            max = Math.max(max, rt - lt + 1);
            rt++;
        }
        System.out.println(max);
    }
}