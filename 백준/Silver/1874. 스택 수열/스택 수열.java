import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ_1874 스택수열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int top = 0;
        while(n-->0){
            int num = Integer.parseInt(br.readLine());

            if(top < num){
                for(int j=top+1; j<=num; j++){
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                top = num;
            } else if (stack.peek() != num){
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append('-').append('\n');
        }
        System.out.println(sb);
    }
}