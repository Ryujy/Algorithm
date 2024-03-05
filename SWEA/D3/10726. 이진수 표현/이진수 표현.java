import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for (int tc=1; tc<T+1; tc++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int ans = (1<<N) -1; // 1111..11 (N개의 1)

      sb.append("#").append(tc).append(" ");
      if ((M&ans) == ans){ // ******** M과 ans를 & 연산하면 M의 마지막 N번까지 모두 1이면 ans와 같게 나옴.
        sb.append("ON");
      } else {
        sb.append("OFF");
      }
      sb.append("\n");
    }//tc end
    System.out.println(sb);
  }
}
