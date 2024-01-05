import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    // 백준 - 서로 다른 부분 문자열의 개수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] S = st.nextToken().split(":");
        int start = Integer.parseInt(S[0]+S[1]);
        String[] E = st.nextToken().split(":");
        int end = Integer.parseInt(E[0] + E[1]);
        String[] Q = st.nextToken().split(":");
        int quit = Integer.parseInt(Q[0]+Q[1]);

        HashMap<String, Integer> map = new HashMap<>();

        int cnt = 0;
        String data = null;

        while ((data = br.readLine()) != null){
            String[] str = data.split(" ");
            if (str[0].isEmpty()) break;
            String[] time = str[0].split(":");
            int tm = Integer.parseInt(time[0]+time[1]);
            String name = str[1];

            // 입장 확인 22:00 - 1 <= 입장 시간 <= 22:00
            if (tm <= start){
                map.put(name, 1);
            } else if (map.containsKey(name)) {
                // 퇴장 확인 end <= 퇴장 <= quit
                if (tm >= end && tm <= quit) {
                    map.replace(name, 2);
                }
            }
        }

        for (int n : map.values()){
            if (n > 1){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}