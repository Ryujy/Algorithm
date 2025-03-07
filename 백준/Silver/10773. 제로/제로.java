import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// BOJ_10773 제로
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0; i<k; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                sum-= stack.pop();
                continue;
            }
            stack.add(n);
            sum+=n;
        }

        System.out.println(sum);
    }
}