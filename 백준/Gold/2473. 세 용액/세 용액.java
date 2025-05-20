import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import static java.lang.Integer.*;
import static java.lang.Math.*;

class Main{ // 2473. 세 용액
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liq = new int[n];
        int[] answer = new int[3];
        for (int i=0; i<n; i++){
            liq[i] = parseInt(st.nextToken());
        }

        Arrays.sort(liq);
        // 특성값이 0에 가깝다 -> 절댓값으로 판단
        long res = Long.MAX_VALUE;

        for (int i=0; i<n-2; i++){
            int lt = i+1;
            int rt = n-1;
            while(lt < rt){
                long sum = (long)liq[lt] + liq[rt] + liq[i];

                if (abs(sum) < abs(res)){
                    res = sum;
                    answer[0] = liq[i];
                    answer[1] = liq[lt];
                    answer[2] = liq[rt];
                }

                if (sum <= 0) lt++;
                else rt--;

            }
        }

        // 출력 => 특성값의 합이 0에 가장 가까운 세 용액의 특성값 (오름차순)
        Arrays.sort(answer);
        for (int i=0; i<3; i++){
            System.out.print(answer[i]+" ");
        }
    }
}