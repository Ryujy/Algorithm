import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// BOJ_2493 탑
public class Main {
    static class top{
        int height;
        int idx;

        top (int height, int idx){
            this.height = height;
            this.idx =idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        Stack<top> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<n; i++){
            int value = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek().height < value){
                stack.pop();
            }
            if(stack.isEmpty()){
                sb.append(0).append(' ');
            } else {
                sb.append(stack.peek().idx).append(" ");
            }
            stack.push(new top(value, i+1));
        }
        System.out.println(sb);
    }
}