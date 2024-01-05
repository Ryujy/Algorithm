import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    // 백준 - 서로 다른 부분 문자열의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        HashSet<String> set = new HashSet<>();

        for (int i=0; i<str.length(); i++){
            for (int j = 1; i+j < str.length()+1; j++){
                set.add(str.substring(i,i+j));
            }
        }
        System.out.println(set.size());
    }
}