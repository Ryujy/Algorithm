import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_2470 두 용액
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 특성값이 0에 가장 가까운 용액을 만들어내는 두 용액의 특성값을 출력한다. (특성값의 오름차순)
        Arrays.sort(arr);

        int lt = 0, rt = n-1;
        int sum;
        int temp = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;
        while(lt < rt){
            sum = arr[lt] + arr[rt];
            if(Math.abs(sum) < temp){
                temp = Math.abs(arr[lt]+arr[rt]);
                ans1 = arr[lt];
                ans2 = arr[rt];
            }
            // 어떤 경우에 lt와 rt를 각각 움직여야하는지 감을 잡기 어려웠다.
            if(sum > 0) rt--;
            else lt++;
        }
        System.out.println(ans1+" "+ans2);
    }
}