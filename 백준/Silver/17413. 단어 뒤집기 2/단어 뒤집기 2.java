import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

// [BOJ] 단어 뒤집기2
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        // 꺽새 열림, 닫힘 판별을 위한 flag
        boolean flag = false;

        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '<'){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                flag = true;
            } else if(S.charAt(i) == '>'){
                flag = false;
                sb.append(S.charAt(i));
                continue;
            }

            if(flag){
                sb.append(S.charAt(i));
            } else if(!flag){
                if(S.charAt(i) == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                    continue;
                } else {
                    stack.push(S.charAt(i));
                }
            }

            if (i == S.length() - 1){
                while (!stack.isEmpty()){
                    sb.append(stack.pop());
                }
            }

        }
        System.out.println(sb);


    }

}