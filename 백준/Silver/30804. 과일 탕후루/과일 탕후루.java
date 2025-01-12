import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// BOJ_30804 과일 탕후루
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] kind = new int[10];
        int[] candy = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            candy[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0 , rt = 0;
        int cnt = 0, max = 0;

        while(rt < n){
            int f1 = candy[rt]; // 탕후루 알 1개
            if(kind[f1] == 0) {
                cnt++; // 과일 종류 추가
                kind[f1]++;
            } else {
                kind[f1]++;
            }

            while(cnt > 2){ // 과일 종류가 3개 이상일 때
                int f2 = candy[lt];
                kind[f2]--;
                if(kind[f2] == 0) cnt--; // 수열에서 해당 과일이 미포함되면
                lt++;
            }
//            System.out.println("rt : " + rt + " lt: "+lt+"len : "+ ((rt-lt)+1));
            max = Math.max(max, (rt-lt)+1);
            rt++;
        }
        System.out.println(max);
    }

}