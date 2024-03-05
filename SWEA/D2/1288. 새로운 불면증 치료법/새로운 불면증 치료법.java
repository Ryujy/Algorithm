import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int tc=1; tc<T+1; tc++){
      int N = Integer.parseInt(br.readLine());
      int cnt = 0;
      int visited = 0;
      int bit = (1<<10) - 1; // 1111111111

      while(visited != bit){
        cnt++;
        char[] arr = String.valueOf(N*cnt).toCharArray();
        for (char c:arr){
          int num = c - '0';
          visited = visited | (1<<num);
        }
      }
      sb.append("#").append(tc).append(" ").append(N*cnt).append("\n");
    }// tc end
    System.out.println(sb);
  }
}