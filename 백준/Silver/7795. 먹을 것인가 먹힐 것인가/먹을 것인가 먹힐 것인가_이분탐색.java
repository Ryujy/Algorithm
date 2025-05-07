import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 초반에는 투포인터로 접근했으나 cnt와 total의 컨트롤이 쉽지 않아 이분탐색으로 전환하여 풀이함.
*/

class Main{ // 7795. 먹을 것인가 먹힐 것인가
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] predator = new int[n];
            int[] prey = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i=0; i<n; i++){
                predator[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++){
                prey[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(predator);
            Arrays.sort(prey);

            int total = 0; // 전체 총합

            for (int p=0; p<n; p++){ 
                int lt =0;
                int rt = m;
                while(lt < rt){
                    int mid = (lt+rt)/2;
                    if (predator[p] > prey[mid]){
                        lt = mid + 1;
                    } else {
                        rt = mid;
                    }
                }
                total += lt;
            }

            System.out.println(total);
        } // tc end
    }
}
