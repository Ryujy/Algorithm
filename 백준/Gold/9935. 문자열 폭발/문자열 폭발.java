import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// [BOJ] 단어 뒤집기2
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
            if (stack.size() >= bomb.length()){
                boolean flag = true;

                for (int j=0; j<bomb.length(); j++){
                    if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }

                if (flag){
                    for (int j=0; j<bomb.length(); j++) stack.pop();
                }
            }
        }

        if (stack.isEmpty()){
            System.out.println("FRULA");
        } else {
            for (Character c : stack){
                sb.append(c);
            }
            System.out.println(sb);
        }
    }

}