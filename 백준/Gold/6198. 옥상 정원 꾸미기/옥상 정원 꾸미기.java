import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ_6198 옥상 정원 꾸미기
public class Main {
    static class top{
        int height;
        long cnt;

        top(int h, long c){
            height = h;
            cnt = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Stack<top> stack = new Stack<>();

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        long ans = 0;
        for (int j=n-1; j>=0; j--){
            int value = arr[j];
            if(stack.isEmpty()){
                stack.push(new top(value, 0));
                continue;
            }
            long cnt = 0;
            while (!stack.isEmpty()&&stack.peek().height < value){
                top temp = stack.pop();
                cnt += temp.cnt +1;
            }
            stack.push(new top(value, cnt));
            ans += cnt;
        }

        System.out.println(ans);
    }
}