import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main{ // 1654. 랜선자르기
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 보유한 랜선 개수
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
        int[] lines = new int[k];
        for (int i=0; i<k; i++){
            lines[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lines);
        long lt = 1;
        long rt = lines[k-1];
        long maxL = 0;
        while(lt <= rt){
            long mid = (lt + rt)/2;
            int cnt = 0;
            for(int l:lines){
                cnt += (l/mid);
            }
            if (cnt >= n){
                lt = mid + 1;
                maxL = mid;

            } else {
                rt = mid - 1;
            }
        }
        System.out.println(maxL);
    }
}